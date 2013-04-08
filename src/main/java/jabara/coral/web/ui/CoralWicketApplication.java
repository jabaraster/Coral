/**
 * 
 */
package jabara.coral.web.ui;

import jabara.coral.model.DI;
import jabara.coral.web.ui.page.IndexPage;
import jabara.coral.web.ui.page.NewProjectWizardItemsPage;
import jabara.coral.web.ui.page.NewProjectWizardNamePage;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.application.IComponentInstantiationListener;
import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * @author jabaraster
 */
public class CoralWicketApplication extends WebApplication {

    private static final String ENC = "UTF-8"; //$NON-NLS-1$

    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends Page> getHomePage() {
        return IndexPage.class;
    }

    /**
     * @see org.apache.wicket.protocol.http.WebApplication#init()
     */
    @Override
    protected void init() {
        super.init();

        mountPages();
        initializeEncoding();
        initializeInjection();
        initializeSecurity();
        initializeOther();
    }

    private void initializeEncoding() {
        getMarkupSettings().setDefaultMarkupEncoding(ENC);
        getRequestCycleSettings().setResponseRequestEncoding(getMarkupSettings().getDefaultMarkupEncoding());
    }

    private void initializeInjection() {
        getComponentInstantiationListeners().add(new GuiceComponentInjector(this, DI.getInjector()));
    }

    private void initializeOther() {
        getComponentInstantiationListeners().add(new IComponentInstantiationListener() {
            @Override
            public void onInstantiation(final Component pComponent) {
                pComponent.setOutputMarkupId(true);
            }
        });
    }

    private void initializeSecurity() {
        // TODO implementation.
    }

    private void mountPages() {
        this.mountPage("project/new", NewProjectWizardNamePage.class); //$NON-NLS-1$
        this.mountPage("project/new/page2", NewProjectWizardItemsPage.class); //$NON-NLS-1$
    }
}
