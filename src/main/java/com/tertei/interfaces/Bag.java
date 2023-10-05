/**
 * This code is based on information and implementations from the following web page:
 * URL: https://algs4.cs.princeton.edu/code/
 * Authors: Robert Sedgewick, Kevin Wayne
 * Date: September 30, 2023
 * <p>
 * Original source: https://algs4.cs.princeton.edu/code/
 */

package com.tertei.interfaces;

/**
 * The {@code Bag} class represents a bag (or multiset) of
 * generic items. It supports insertion and iterating over the
 * items in arbitrary order.
 *
 * @author Srdan Tertei
 *
 * @param <Item>
 */
public interface Bag<Item> extends Iterable<Item>{

    /**
     * Adds the item to this bag.
     *
     * @param  item the item to add
     */
    void add(Item item);

    /**
     * Returns true if this bag is empty.
     *
     * @return true if this bag is empty; false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of items in this bag.
     *
     * @return the number of items in this bag
     */
    int size();

    /**
     * Returns a string representation of this bag.
     *
     * @return the sequence of items in this bag, separated by spaces
     */
    String toString();
}
