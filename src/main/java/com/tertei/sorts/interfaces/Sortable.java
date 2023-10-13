/**
 * This code is based on information and implementations from the following web page:
 * URL: https://algs4.cs.princeton.edu/code/
 * Authors: Robert Sedgewick, Kevin Wayne
 * Date: September 30, 2023
 * <p>
 * Original source: https://algs4.cs.princeton.edu/code/
 */

package com.tertei.sorts.interfaces;

/**
 * The {@code Sortable} interface has method sort that accept array of objects that implements Comparable interface.
 * Result will be sorted in natural order
 *
 * @author Srdan Tertei
 */
public interface Sortable {
    /**
     * Sort array of objects in natural order
     *
     * @param items Array of objects that implements Comparable interface.
     */
    void sort(Comparable[] items);
}
