/**
 * 
 */
package jabara.coral.entity;

import jabara.coral.model.IIndexable;
import jabara.jpa.entity.EntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author jabaraster
 */
@Entity
public class EItemValueSelection extends EntityBase<EItemValueSelection> implements IIndexable {
    private static final long serialVersionUID = 591766783576496470L;

    /**
     * 
     */
    public static final int   MAX_LENGTH_VALUE = 100;

    /**
     * 
     */
    @Column(nullable = false)
    protected int             index;

    /**
     * 
     */
    @Column(nullable = false, length = MAX_LENGTH_VALUE * 3)
    @NotNull
    @Size(min = 1, max = MAX_LENGTH_VALUE)
    protected String          value;

    /**
     * 
     */
    public EItemValueSelection() {
        // 処理なし
    }

    /**
     * @param pIndex
     * @param pValue
     */
    public EItemValueSelection(final int pIndex, final String pValue) {
        this.index = pIndex;
        this.value = pValue;
    }

    /**
     * @return indexを返す.
     */
    @Override
    public int getIndex() {
        return this.index;
    }

    /**
     * @return valueを返す.
     */
    public String getValue() {
        return this.value;
    }

    /**
     * @param pIndex indexを設定.
     */
    public void setIndex(final int pIndex) {
        this.index = pIndex;
    }

    /**
     * @param pValue valueを設定.
     */
    public void setValue(final String pValue) {
        this.value = pValue;
    }
}
