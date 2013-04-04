/**
 * 
 */
package jabara.coral.entity;

import jabara.jpa.entity.EntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

/**
 * @author jabaraster
 */
@Entity
public class EProject extends EntityBase<EProject> {
    private static final long serialVersionUID = -3939351371696244299L;

    /**
     * 
     */
    public static final int   MAX_LENGTH_NAME  = 100;

    /**
     * 
     */
    @Column(nullable = false, length = MAX_LENGTH_NAME * 3, unique = true)
    @Size(min = 1, max = MAX_LENGTH_NAME)
    protected String          name;

    /**
     * 
     */
    public EProject() {
        // 処理なし
    }

    /**
     * @param pName
     */
    public EProject(final String pName) {
        this.name = pName;
    }

    /**
     * @return nameを返す.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param pName nameを設定.
     */
    public void setName(final String pName) {
        this.name = pName;
    }

}
