/**
 * 
 */
package jabara.coral.entity;

import jabara.coral.model.IIndexable;
import jabara.general.ArgUtil;
import jabara.jpa.entity.EntityBase;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 * @author jabaraster
 */
@Entity
public class EItem extends EntityBase<EItem> implements IIndexable {
    private static final long          serialVersionUID = 1015966630142059444L;

    /**
     * 
     */
    public static final int            MAX_LENGTH_LABEL = 50;

    /**
     * 
     */
    @Column(nullable = false, length = MAX_LENGTH_LABEL * 3)
    @Size(min = 1, max = MAX_LENGTH_LABEL)
    protected String                   label;
    /**
     * 
     */
    @Column(nullable = false)
    protected int                      index;

    /**
     * 
     */
    @OneToMany(cascade = CascadeType.ALL)
    protected Set<EItemValueSelection> selections       = new HashSet<>();

    /**
     * 
     */
    public EItem() {
        // 処理なし
    }

    /**
     * @param pLabel
     * @param pSelectionNames
     */
    public EItem(final String pLabel, final String... pSelectionNames) {
        ArgUtil.checkNull(pSelectionNames, "pSelectionNames"); //$NON-NLS-1$

        this.label = pLabel;

        this.selections = new HashSet<>();

        for (int idx = 0; idx < pSelectionNames.length; idx++) {
            final String selectionName = pSelectionNames[idx];
            if (selectionName == null) {
                throw new IllegalArgumentException("Element of pSelectionName is not allowed null."); //$NON-NLS-1$
            }
            this.selections.add(new EItemValueSelection(idx, selectionName));
        }
    }

    /**
     * @return indexを返す.
     */
    @Override
    public int getIndex() {
        return this.index;
    }

    /**
     * @return labelを返す.
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * @return selectionsを返す.
     */
    public Set<EItemValueSelection> getSelections() {
        return this.selections;
    }

    /**
     * @return index値でソート済みの選択肢群.
     */
    public SortedSet<EItemValueSelection> getSelectionsSnapshotWithIndexSorted() {
        final SortedSet<EItemValueSelection> ret = new TreeSet<>(IIndexable.U.getComparator());
        ret.addAll(this.selections);
        return ret;
    }

    /**
     * @param pIndex indexを設定.
     */
    public void setIndex(final int pIndex) {
        this.index = pIndex;
    }

    /**
     * @param pLabel labelを設定.
     */
    public void setLabel(final String pLabel) {
        this.label = pLabel;
    }
}
