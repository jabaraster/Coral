/**
 * 
 */
package jabara.coral.service;

import jabara.coral.entity.EItemSet;
import jabara.coral.service.impl.ItemSetServiceImpl;
import jabara.general.NotFound;

import com.google.inject.ImplementedBy;

/**
 * @author jabaraster
 */
@ImplementedBy(ItemSetServiceImpl.class)
public interface IItemSetService {

    /**
     * @param pProjectId
     * @return プロジェクトの項目一覧.
     * @throws NotFound
     */
    EItemSet findByProjectId(long pProjectId) throws NotFound;

    /**
     * @param pItemSet
     */
    void insert(EItemSet pItemSet);
}
