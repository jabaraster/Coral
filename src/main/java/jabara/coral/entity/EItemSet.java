/**
 * 
 */
package jabara.coral.entity;

import jabara.coral.model.IIndexable;
import jabara.jpa.entity.EntityBase;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author jabaraster
 */
@Entity
public class EItemSet extends EntityBase<EItemSet> {
    private static final long serialVersionUID = 7104889345698517886L;

    /**
     * 
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    protected EProject        project;

    /**
     * 
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
    protected Set<EItem>      items            = new HashSet<>();

    /**
     * @return itemsを返す.
     */
    public Set<EItem> getItems() {
        return this.items;
    }

    /**
     * @return index値でソート済みの項目一覧.
     */
    public SortedSet<EItem> getItemsSnapshotWithIndexSorted() {
        final SortedSet<EItem> ret = new TreeSet<>(IIndexable.U.getComparator());
        ret.addAll(this.items);
        return ret;
    }

    /**
     * @return projectを返す.
     */
    public EProject getProject() {
        return this.project;
    }

    /**
     * @param pProject projectを設定.
     */
    public void setProject(final EProject pProject) {
        this.project = pProject;
    }
}
