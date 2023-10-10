/**
 * This code is based on information and implementations from the following web page:
 * URL: https://algs4.cs.princeton.edu/code/
 * Authors: Robert Sedgewick, Kevin Wayne
 * Date: September 30, 2023
 * <p>
 * Original source: https://algs4.cs.princeton.edu/code/
 */

package com.tertei.sorts.impl;

/**
 * Implementation of two methods: less and exchange
 * Sort algorithms will use only those two methods in implementation
 */
public class SortHelpers {

    // is v < w ?
    static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
