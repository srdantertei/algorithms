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

import static com.tertei.sorts.impl.SortHelpers.*;

/**
 *  The {@code QuickSort} class provides method for sorting an
 *  array and selecting the ith smallest element in an array using quicksort.
 *  <p>
 */

public class QuickSort implements Sortable {

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a){
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi + 1;
        while(true){
            while(less(a[++i], a[lo]))
                if(i == hi) break;

            while(less(a[lo], a[--j]))
                if(j == lo) break;

            if(i >= j) break;
            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;
    }
}
