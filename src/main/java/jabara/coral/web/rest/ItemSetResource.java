/**
 * 
 */
package jabara.coral.web.rest;

import jabara.coral.entity.EItem;
import jabara.coral.service.IItemSetService;
import jabara.general.NotFound;

import java.util.SortedSet;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * @author jabaraster
 */
public class ItemSetResource {

    private final IItemSetService itemSetService;

    private long                  projectId;

    /**
     * @param pItemSetService
     */
    @Inject
    public ItemSetResource(final IItemSetService pItemSetService) {
        this.itemSetService = pItemSetService;
    }

    /**
     * @return -
     * @throws NotFound
     */
    @Path("items")
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getItems() throws NotFound {
        try {
            final SortedSet<EItem> list = this.itemSetService.findByProjectId(this.projectId).getItemsSnapshotWithIndexSorted();
            return Response.ok(list).build();
        } catch (final NotFound e) {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    /**
     * @param pProjectId projectIdを設定.
     */
    public void setProjectId(final long pProjectId) {
        this.projectId = pProjectId;
    }
}
