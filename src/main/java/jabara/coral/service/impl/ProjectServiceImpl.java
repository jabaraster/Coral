/**
 * 
 */
package jabara.coral.service.impl;

import jabara.coral.entity.EProject;
import jabara.coral.service.IProjectService;
import jabara.general.ArgUtil;
import jabara.jpa.JpaDaoBase;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;

/**
 * @author jabaraster
 */
public class ProjectServiceImpl extends JpaDaoBase implements IProjectService {
    private static final long serialVersionUID = -301146679321376898L;

    /**
     * @param pEntityManagerFactory
     */
    @Inject
    public ProjectServiceImpl(final EntityManagerFactory pEntityManagerFactory) {
        super(pEntityManagerFactory);
    }

    /**
     * @see jabara.coral.service.IProjectService#insert(jabara.coral.entity.EProject)
     */
    @Override
    public void insert(final EProject pProject) {
        ArgUtil.checkNull(pProject, "pProject"); //$NON-NLS-1$
        getEntityManager().persist(pProject);
    }

}
