/**
 * 
 */
package jabara.coral.model;

import java.util.Comparator;

/**
 * @author jabaraster
 */
public interface IIndexable {
    /**
     * 
     */
    public static final Comparator<IIndexable> COMPARATOR = new Comparator<IIndexable>() {
                                                              @Override
                                                              public int compare(final IIndexable o1, final IIndexable o2) {
                                                                  return o1.getIndex() - o2.getIndex();
                                                              }
                                                          };

    /**
     * @return index値.
     */
    int getIndex();

    /**
     * @author jabaraster
     */
    public static final class U {
        /**
         * @param <T>
         * @return ソート用オブジェクト.
         */
        @SuppressWarnings("unchecked")
        public static <T extends IIndexable> Comparator<T> getComparator() {
            return (Comparator<T>) COMPARATOR;
        }
    }
}
