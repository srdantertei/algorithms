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
 *  The {@code Merge} class provides methods for sorting an
 *  array using a top-down, recursive version of <em>mergesort</em>.
 *  <p>
 *  This implementation takes &Theta;(<em>n</em> log <em>n</em>) time
 *  to sort any array of length <em>n</em> (assuming comparisons
 *  take constant time). It makes between
 *  ~ &frac12; <em>n</em> log<sub>2</sub> <em>n</em> and
 *  ~ 1 <em>n</em> log<sub>2</sub> <em>n</em> compares.
 *  <p>
 *  This sorting algorithm is stable.
 *  It uses &Theta;(<em>n</em>) extra memory (not including the input array).
 *  <p>
 */
public class MergeSort implements Sortable {

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    // recursive function
    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if(hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux,mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    // merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        // copy to auxiliary array
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }

        // merge
        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <= hi; k++){
            if(i > mid){
                a[k] = aux[j++];
            }
            else if(j > hi){
                a[k] = aux[i++];
            }
            else if(SortHelpers.less(aux[j],aux[i])){
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
