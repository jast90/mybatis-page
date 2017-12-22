package cn.jastz.domain;

/**
 * @author zhiwen
 */
public interface Page<T> extends Slice<T> {

    /**
     * Returns the number of total pages.
     *
     * @return the number of total pages
     */
    int getTotalPages();

    /**
     * Returns the total amount of elements.
     *
     * @return the total amount of elements
     */
    long getTotalElements();
}
