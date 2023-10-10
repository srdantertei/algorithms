/**
 * This code is based on information and implementations from the following web page:
 * URL: https://algs4.cs.princeton.edu/code/
 * Authors: Robert Sedgewick, Kevin Wayne
 * Date: September 30, 2023
 * <p>
 * Original source: https://algs4.cs.princeton.edu/code/
 */

package com.tertei.datastructures.impl;

import com.tertei.datastructures.interfaces.Bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This implementation of Bag interface uses resizing array, which double the underlying array
 * when it is full and halves the underlying array when it is one-quarter full.
 * <p>
 * The <em>add</em> operation takes constant amortized time.
 * The <em>size</em>, and <em>is-empty</em> operations all take constant time in the worst case.
 * The <em>toString</em> and <em>iterator</em> operations all take linear time in the worst case.
 *
 * @param <Item>
 */
public class BagWithArray<Item> implements Bag<Item> {

    private Item[] a; // array of items
    private int n; // number of items in bag

    /**
     * Initializes an empty bag.
     */
    @SuppressWarnings("unchecked")
    public BagWithArray(){
        this.a = (Item[]) new Object[2];
        n = 0;
    }

    /**
     * Adds the item to this bag.
     *
     * @param  item the item to add
     */
    @Override
    public void add(Item item) {
        if(n == a.length){
            resize(a.length*2);
        }
        a[n] = item;
        n++;
    }

    /**
     * Returns true if this bag is empty.
     *
     * @return true if this bag is empty; false otherwise
     */
    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in this bag.
     *
     * @return the number of items in this bag
     */
    @Override
    public int size() {
        return n;
    }

    /**
     * Returns a string representation of this bag.
     *
     * @return the sequence of items in this bag, separated by spaces
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

    /**
     * Returns an iterator that iterates over the items in this bag in arbitrary order.
     *
     * @return an iterator that iterates over the items in this bag in arbitrary order
     */
    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item>{

        private int current; //position of iterator

        public ArrayIterator(){
            current = 0;
        }

        @Override
        public boolean hasNext() {
            return current < n;
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException("There is no more elements in bag!");
            }
            return a[current++];
        }
    }

    // resize the underlying array holding the elements
    @SuppressWarnings("unchecked")
    private void resize(int capacity){
        Item[] copy = (Item[])new Object[capacity];
        if (0 <= n) System.arraycopy(a, 0, copy, 0, n);
        a = copy;
    }
}
