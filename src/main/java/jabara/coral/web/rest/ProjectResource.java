/**
 * 
 */
package jabara.coral.web.rest;

import jabara.coral.model.DI;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author jabaraster
 */
@Path("project")
public class ProjectResource {

    private static final String KEY_ID = "id"; //$NON-NLS-1$

    /**
     * @param pProjectId
     * @return -
     */
    @SuppressWarnings({ "static-method" })
    @Path("{" + KEY_ID + "}")
    public ItemSetResource getItems(@PathParam(KEY_ID) final long pProjectId) {
        final ItemSetResource ret = DI.get(ItemSetResource.class);
        ret.setProjectId(pProjectId);
        return ret;
    }
}
