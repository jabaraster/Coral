/**
 * 
 */
package jabara.coral.web.ui.page;

import jabara.coral.entity.EProject;
import jabara.coral.web.ui.component.ItemsPanel;
import jabara.general.ArgUtil;

import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author jabaraster
 */
public class NewProjectWizardItemsPage extends RestrictedPageBase {
    private static final long serialVersionUID = 1337283185188215712L;

    private final EProject    projectValue;
    private final WebPage     previousPage;

    private FeedbackPanel     feedback;

    private Form<?>           form;
    private AjaxButton        submitter;
    private Link<?>           goPrevious;

    private ItemsPanel        items;

    /**
     * @param pProjectValue
     * @param pPreviousPage
     */
    public NewProjectWizardItemsPage(final EProject pProjectValue, final WebPage pPreviousPage) {
        ArgUtil.checkNull(pProjectValue, "pProjectValue"); //$NON-NLS-1$
        ArgUtil.checkNull(pPreviousPage, "pPreviousPage"); //$NON-NLS-1$
        this.projectValue = pProjectValue;
        this.previousPage = pPreviousPage;

        this.add(getFeedback());
        this.add(getForm());
    }

    /**
     * @see jabara.coral.web.ui.page.CoralWebPageBase#getTitleLabelModel()
     */
    @Override
    protected IModel<String> getTitleLabelModel() {
        return Model.of("新しいプロジェクト - 項目名"); //$NON-NLS-1$
    }

    private FeedbackPanel getFeedback() {
        if (this.feedback == null) {
            this.feedback = new FeedbackPanel("feedback"); //$NON-NLS-1$
        }
        return this.feedback;
    }

    private Form<?> getForm() {
        if (this.form == null) {
            this.form = new Form<>("form"); //$NON-NLS-1$
            this.form.add(getItems());
            this.form.add(getSubmitter());
            this.form.add(getGoPrevious());
        }
        return this.form;
    }

    private Link<?> getGoPrevious() {
        if (this.goPrevious == null) {
            this.goPrevious = new Link<Object>("goPrevious") { //$NON-NLS-1$
                private static final long serialVersionUID = 6378008889229117612L;

                @SuppressWarnings("synthetic-access")
                @Override
                public void onClick() {
                    this.setResponsePage(NewProjectWizardItemsPage.this.previousPage);
                }
            };
        }
        return this.goPrevious;
    }

    private ItemsPanel getItems() {
        if (this.items == null) {
            this.items = new ItemsPanel("items", this.projectValue.getItems()); //$NON-NLS-1$
        }
        return this.items;
    }

    private AjaxButton getSubmitter() {
        if (this.submitter == null) {
            this.submitter = new IndicatingAjaxButton("submitter") {
            };
        }
        return this.submitter;
    }
}
