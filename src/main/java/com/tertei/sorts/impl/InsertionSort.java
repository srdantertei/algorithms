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
 *  The {@code Insertion} class provides method for sorting an
 *  array using insertion sort.
 *  <p>
 *  In the worst case, this implementation makes ~ &frac12; <em>n</em><sup>2</sup>
 *  compares and ~ &frac12; <em>n</em><sup>2</sup> exchanges to sort an array
 *  of length <em>n</em>. So, it is not suitable for sorting large arbitrary
 *  arrays. More precisely, the number of exchanges is exactly equal to the
 *  number of inversions. So, for example, it sorts a partially-sorted array
 *  in linear time.
 *  <p>
 *  This sorting algorithm is stable.
 *  It uses &Theta;(1) extra memory (not including the input array).
 *  <p>
 *  @param <Item>
 */
public class InsertionSort<Item extends Comparable<Item>> implements Sortable<Item> {

    /**
     * Sort array of objects in natural order using Insertion sort algorithm
     *
     * @param a Array of objects that implements Comparable interface.
     */
    @Override
    public void sort(Item[] a) {
        int N = a.length;
        for(int i = 1; i < N; i++){
            // take element and move it left till left side is sorted
            for(int j = 0; j < i; j++){
                if(SortHelpers.less(a[i-j], a[i-j-1])){
                    SortHelpers.exch(a, i-j-1, i-j);
                } else {
                    break;
                }
            }
        }
    }
}
