/**
 * 
 */
package jabara.coral.web.rest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author jabaraster
 */
@Path("/")
public class ProjectResource {

    private static final String KEY_ID = "id"; //$NON-NLS-1$

    /**
     * @param pProjectId
     * @return -
     */
    @SuppressWarnings({ "static-method", "boxing" })
    @Path("/projects/{id}")
    @GET
    public List<Integer> getItems(@PathParam("id") final long pProjectId) {
        return Arrays.asList(1, 2, 3);
        // final ItemSetResource ret = DI.get(ItemSetResource.class);
        // ret.setProjectId(pProjectId);
        // return ret;
    }
}
