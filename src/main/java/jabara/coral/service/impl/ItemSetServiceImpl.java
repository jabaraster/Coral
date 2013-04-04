/**
 * 
 */
package jabara.coral.service.impl;

import jabara.coral.entity.EItemSet;
import jabara.coral.entity.EItemSet_;
import jabara.coral.service.IItemSetService;
import jabara.general.ArgUtil;
import jabara.general.NotFound;
import jabara.jpa.JpaDaoBase;
import jabara.jpa.entity.EntityBase_;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

/**
 * @author jabaraster
 */
public class ItemSetServiceImpl extends JpaDaoBase implements IItemSetService {
    private static final long serialVersionUID = 2523099433292796660L;

    /**
     * @param pEntityManagerFactory
     */
    @Inject
    public ItemSetServiceImpl(final EntityManagerFactory pEntityManagerFactory) {
        super(pEntityManagerFactory);
    }

    /**
     * @see jabara.coral.service.IItemSetService#findByProjectId(long)
     */
    @Override
    public EItemSet findByProjectId(final long pProjectId) throws NotFound {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder builder = em.getCriteriaBuilder();
        final CriteriaQuery<EItemSet> query = builder.createQuery(EItemSet.class);
        final Root<EItemSet> root = query.from(EItemSet.class);

        query.distinct(true);
        root.fetch(EItemSet_.items, JoinType.LEFT);

        query.where( //
        builder.equal(root.get(EItemSet_.project).get(EntityBase_.id), Long.valueOf(pProjectId)) //
        );

        return getSingleResult(em.createQuery(query));
    }

    /**
     * @see jabara.coral.service.IItemSetService#insert(jabara.coral.entity.EItemSet)
     */
    @Override
    public void insert(final EItemSet pItemSet) {
        ArgUtil.checkNull(pItemSet, "pItemSet"); //$NON-NLS-1$
        getEntityManager().persist(pItemSet);
    }

}
