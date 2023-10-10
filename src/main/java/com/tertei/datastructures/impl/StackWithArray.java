/**
 * This code is based on information and implementations from the following web page:
 * URL: https://algs4.cs.princeton.edu/code/
 * Authors: Robert Sedgewick, Kevin Wayne
 * Date: September 30, 2023
 * <p>
 * Original source: https://algs4.cs.princeton.edu/code/
 */

package com.tertei.datastructures.impl;

import com.tertei.datastructures.interfaces.Stack;
import java.util.NoSuchElementException;

/**
 *  This implementation uses a resizing array, which double the underlying array
 *  when it is full and halves the underlying array when it is one-quarter full.
 *  <p>
 *  The <em>push</em> and <em>pop</em> operations take constant amortized time.
 *  The <em>peek</em>, <em>size</em>, and <em>is-empty</em> operations
 *  all take constant time in the worst case.
 *  The <em>toString</em> operation takes linear time in the worst case.
 *  </p>
 * @param <Item>
 */
public class StackWithArray<Item> implements Stack<Item> {

    private Item[] a; // array of items
    private int n; // number of elements on stack

    /**
     * Initializes an empty stack.
     */
    @SuppressWarnings("unchecked")
    public StackWithArray(){
        this.a = (Item[]) new Object[2];
        this.n = 0;
    }

    /**
     * Adds the item to this stack.
     *
     * @param  item the item to add
     */
    @Override
    public void push(Item item) {
        if(n == a.length){
            resize(a.length*2);
        }
        a[n] = item;
        n++;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    @Override
    public Item pop() {
        if(isEmpty()){
            throw new NoSuchElementException("Stack underflow!");
        }
        Item item = a[n-1];
        a[n-1] = null; // to release unused reference from array, to allow GC to clean
        n--;
        if(n == a.length/4){
            resize(a.length/2);
        }
        return item;
    }

    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    @Override
    public Item peek() {
        if(isEmpty()){
            throw new NoSuchElementException("Stack underflow!");
        }
        return a[n-1];
    }

    /**
     * Returns the number of items in this stack.
     *
     * @return the number of items in this stack
     */
    @Override
    public int size() {
        return n;
    }

    /**
     * Returns true if this stack is empty.
     *
     * @return true if this stack is empty; false otherwise
     */
    @Override
    public boolean isEmpty() {
        return 0 == n;
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return the sequence of items in this stack in LIFO order, separated by spaces
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(a[i].toString());
            sb.append(" ");
        }
        return sb.toString();
    }

    // resize the underlying array holding the elements
    @SuppressWarnings("unchecked")
    private void resize(int capacity){
        Item[] copy = (Item[])new Object[capacity];
        if (0 <= n) System.arraycopy(a, 0, copy, 0, n);
        a = copy;
    }

}
