/**
 * 
 */
package jabara.coral.web.rest;

import jabara.coral.model.DI;
import jabara.jax_rs.JsonMessageBodyReaderWriter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

/**
 * @author jabaraster
 */
public class CoralRestApplication extends Application {

    /**
     * @see javax.ws.rs.core.Application#getClasses()
     */
    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Arrays.asList( //
                JsonMessageBodyReaderWriter.class //
                ));
    }

    /**
     * @see javax.ws.rs.core.Application#getSingletons()
     */
    @Override
    public Set<Object> getSingletons() {
        return new HashSet<Object>(Arrays.asList( //
                DI.get(ProjectResource.class) //
                ));
    }
}
