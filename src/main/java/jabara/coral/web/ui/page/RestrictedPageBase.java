/**
 * 
 */
package jabara.coral.web.ui.page;

import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author jabaraster
 */
public abstract class RestrictedPageBase extends CoralWebPageBase {
    private static final long serialVersionUID = -7167986041931382061L;

    /**
     * 
     */
    protected RestrictedPageBase() {
        super();
    }

    /**
     * @param pParameters
     */
    protected RestrictedPageBase(final PageParameters pParameters) {
        super(pParameters);
    }
}
