/**
 * This code is based on information and implementations from the following web page:
 * URL: https://algs4.cs.princeton.edu/code/
 * Authors: Robert Sedgewick, Kevin Wayne
 * Date: September 30, 2023
 * <p>
 * Original source: https://algs4.cs.princeton.edu/code/
 */

package com.tertei.datastructures.interfaces;

import java.util.NoSuchElementException;

/**
 * The {@code Stack} interface represents a last-in-first-out (LIFO) stack of generic items.
 * It supports the usual <em>push</em> and <em>pop</em> operations, along with methods
 * for peeking at the top item, testing if the stack is empty, number of elements in stack
 * and returns a string representation of the stack.
 *
 * @author Srdan Tertei
 *
 * @param <Item> the generic type each item in this stack
 */

public interface Stack<Item> {

    /**
     * Adds the item to this stack.
     *
     * @param  item the item to add
     */
    void push(Item item);

    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    Item pop() throws NoSuchElementException;

    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    Item peek() throws NoSuchElementException;

    /**
     * Returns the number of items in this stack.
     *
     * @return the number of items in this stack
     */
    int size();

    /**
     * Returns true if this stack is empty.
     *
     * @return true if this stack is empty; false otherwise
     */
    boolean isEmpty();

    /**
     * Returns a string representation of this stack.
     *
     * @return the sequence of items in this stack in LIFO order, separated by spaces
     */
    String toString();
}