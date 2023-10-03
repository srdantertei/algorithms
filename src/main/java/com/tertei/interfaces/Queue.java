/**
 * This code is based on information and implementations from the following web page:
 * URL: https://algs4.cs.princeton.edu/code/
 * Authors: Robert Sedgewick, Kevin Wayne
 * Date: September 30, 2023
 * <p>
 * Original source: https://algs4.cs.princeton.edu/code/
 */

package com.tertei.interfaces;

import java.util.NoSuchElementException;

/**
 * The {@code Queue} interface represents a first-in-first-out (FIFO) queue of generic items.
 * It supports the usual <em>enqueue</em> and <em>dequeue</em> operations, along with methods
 * for peeking at the top item, testing if the queue is empty, number of elements in queue
 * and returns a string representation of the queue.
 *
 * @author Srdan Tertei
 *
 * @param <Item> the generic type each item in this queue
 */

public interface Queue<Item> {

    /**
     * Adds the item to this queue.
     *
     * @param  item the item to add
     */
    void enqueue(Item item);

    /**
     * Removes and returns the item least recently added to this queue.
     *
     * @return the item least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    Item dequeue() throws NoSuchElementException;

    /**
     * Returns (but does not remove) the item least recently added to this queue.
     *
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    Item peek() throws NoSuchElementException;

    /**
     * Returns true if this queue is empty.
     *
     * @return true if this queue is empty; false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    int size();

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in this queue in FIFO order, separated by spaces
     */
    String toString();
}
