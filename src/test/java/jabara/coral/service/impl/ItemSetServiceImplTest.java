/**
 * 
 */
package jabara.coral.service.impl;

import jabara.coral.CoralWebStarter;
import jabara.coral.entity.EItem;
import jabara.coral.entity.EItemSet;
import jabara.coral.entity.EItemValueSelection;
import jabara.coral.entity.EProject;
import jabara.coral.service.IItemSetService;
import jabara.coral.service.IProjectService;
import jabara.general.ArgUtil;
import jabara.general.NotFound;
import jabara.jpa_guice.ThreadLocalEntityManagerFactoryHandler;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author jabaraster
 */
public class ItemSetServiceImplTest {

    private static EntityManagerFactory _emf;

    private EntityManager               em;

    private IProjectService             projectService;
    private IItemSetService             service;

    /**
     * @throws NotFound
     */
    @SuppressWarnings("nls")
    @Test
    public void _findByProjectId() throws NotFound {
        final EntityManager i = ArgUtil.checkNull(this.em, "em");
        jabara.Debug.write(i);

        final EProject project = new EProject("Sampe Project"); //$NON-NLS-1$
        this.projectService.insert(project);

        final EItemSet itemSet = new EItemSet();
        itemSet.getItems().add(new EItem("項目１", "A", "B", "C", "D", "Z", "X"));
        itemSet.setProject(project);

        this.service.insert(itemSet);

        this.em.flush();

        for (final EItem item : this.service.findByProjectId(itemSet.getId().longValue()).getItems()) {
            System.out.println(item.getLabel());
            for (final EItemValueSelection selection : item.getSelectionsSnapshotWithIndexSorted()) {
                System.out.println("  " + selection.getValue());
            }
        }
    }

    /**
     * 
     */
    @Before
    public void setUp() {
        this.service = new ItemSetServiceImpl(_emf);
        this.projectService = new ProjectServiceImpl(_emf);

        this.em = _emf.createEntityManager();
        this.em.getTransaction().begin();
    }

    /**
     * 
     */
    @After
    public void tearDown() {
        if (this.em == null) {
            return;
        }
        final EntityTransaction tx = this.em.getTransaction();
        if (tx.isActive()) {
            tx.rollback();
        }
    }

    /**
     * @throws NamingException
     */
    @BeforeClass
    public static void setUpClass() throws NamingException {
        CoralWebStarter.initializeDataSource();
        _emf = ThreadLocalEntityManagerFactoryHandler.wrap(Persistence.createEntityManagerFactory("Coral")); //$NON-NLS-1$
    }
}
