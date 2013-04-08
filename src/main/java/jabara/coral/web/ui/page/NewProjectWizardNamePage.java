/**
 * 
 */
package jabara.coral.web.ui.page;

import jabara.coral.entity.EProject;
import jabara.coral.entity.EProject_;
import jabara.wicket.ValidatorUtil;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

/**
 * @author jabaraster
 */
public class NewProjectWizardNamePage extends RestrictedPageBase {
    private static final long serialVersionUID = -4068427553547703678L;

    private final EProject    projectValue     = new EProject();

    private FeedbackPanel     feedback;
    private Form<?>           form;
    private TextField<String> projectName;
    private AjaxButton        goNext;

    /**
     * 
     */
    public NewProjectWizardNamePage() {
        this.add(getFeedback());
        this.add(getForm());
    }

    /**
     * @see jabara.coral.web.ui.page.CoralWebPageBase#getTitleLabelModel()
     */
    @Override
    protected IModel<String> getTitleLabelModel() {
        return Model.of("新しいプロジェクト - プロジェクト名"); //$NON-NLS-1$
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
            this.form.add(getProjectName());
            this.form.add(getGoNext());

        }
        return this.form;
    }

    @SuppressWarnings("serial")
    private AjaxButton getGoNext() {
        if (this.goNext == null) {
            this.goNext = new IndicatingAjaxButton("goNext") { //$NON-NLS-1$
                @SuppressWarnings({ "synthetic-access" })
                @Override
                protected void onError(final AjaxRequestTarget pTarget, @SuppressWarnings("unused") final Form<?> pForm) {
                    pTarget.add(getFeedback());
                    pTarget.add(getForm());
                }

                @SuppressWarnings("synthetic-access")
                @Override
                protected void onSubmit(@SuppressWarnings("unused") final AjaxRequestTarget pTarget, @SuppressWarnings("unused") final Form<?> pForm) {
                    this.setResponsePage(new NewProjectWizardItemsPage(NewProjectWizardNamePage.this.projectValue, NewProjectWizardNamePage.this));
                }
            };
        }
        return this.goNext;
    }

    private TextField<String> getProjectName() {
        if (this.projectName == null) {
            this.projectName = new TextField<>("projectName", new PropertyModel<String>(this.projectValue, EProject_.name.getName())); //$NON-NLS-1$
            ValidatorUtil.setSimpleStringValidator(this.projectName, EProject.class, EProject_.name);
        }
        return this.projectName;
    }
}
