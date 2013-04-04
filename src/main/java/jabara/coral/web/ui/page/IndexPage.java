/**
 * 
 */
package jabara.coral.web.ui.page;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author jabaraster
 */
public class IndexPage extends RestrictedPageBase {
    private static final long serialVersionUID = -4965903336608758671L;

    /**
     * @see jabara.coral.web.ui.page.CoralWebPageBase#getTitleLabelModel()
     */
    @Override
    protected IModel<String> getTitleLabelModel() {
        return Model.of("Top"); //$NON-NLS-1$
    }

}
