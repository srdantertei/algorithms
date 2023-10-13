/**
 * This code is based on information and implementations from the following web page:
 * URL: https://algs4.cs.princeton.edu/code/
 * Authors: Robert Sedgewick, Kevin Wayne
 * Date: September 30, 2023
 * <p>
 * Original source: https://algs4.cs.princeton.edu/code/
 */

package com.tertei.sorts.impl;

import com.tertei.sorts.interfaces.Sortable;

/**
 *
 *  The {@code SelectionSort} class provides method for sorting an
 *  array using <em>selection sort</em>.
 *  This implementation makes ~ &frac12; <em>n</em><sup>2</sup> compares to sort
 *  any array of length <em>n</em>, so it is not suitable for sorting large arrays.
 *  It performs exactly <em>n</em> exchanges.
 *  <p>
 *  This sorting algorithm is not stable. It uses &Theta;(1) extra memory
 *  (not including the input array).
 *  <p>
 */
public class SelectionSort implements Sortable {

    /**
     * Sort array of objects in natural order using Selection sort algorithm
     *
     * @param a Array of objects that implements Comparable interface.
     */
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for(int i = 0; i < N; i++){
            int min = i;
            for(int j = i+1; j < N; j++){
                if(SortHelpers.less(a[j], a[min])){
                    min = j;
                }
            }
            SortHelpers.exch(a, i, min);
        }
    }
}
