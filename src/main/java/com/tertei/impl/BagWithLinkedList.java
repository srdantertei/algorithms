/**
 * This code is based on information and implementations from the following web page:
 * URL: https://algs4.cs.princeton.edu/code/
 * Authors: Robert Sedgewick, Kevin Wayne
 * Date: September 30, 2023
 * <p>
 * Original source: https://algs4.cs.princeton.edu/code/
 */

package com.tertei.impl;

import com.tertei.interfaces.Bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This implementation of Bag interface uses a singly linked list with a static nested class for
 * linked-list nodes.
 * <p>
 * The <em>add</em>, <em>size</em>, and <em>is-empty</em>
 * operations all take constant time in the worst case.
 * The <em>toString</em> and <em>iterator</em> operations all take linear time in the worst case.
 *
 * @param <Item>
 */
public class BagWithLinkedList<Item> implements Bag<Item> {

    private Node<Item> first; // reference to first element in bag
    private int n; // number of items in bag

    /**
     * Initializes an empty bag.
     */
    public BagWithLinkedList(){
        n = 0;
    }

    // helper linked list class
    private static class Node<Item>{
        private final Item item;
        private Node<Item> next;

        private Node(Item item){
            this.item = item;
            this.next = null;
        }
    }

    /**
     * Adds the item to this bag.
     *
     * @param  item the item to add
     */
    @Override
    public void add(Item item) {
        Node<Item> previousFirst = first;
        first = new Node<>(item);
        first.next = previousFirst;
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
    public String toString() {
        StringBuilder retVal = new StringBuilder();
        if (!isEmpty()){
            retVal.append(first.item.toString());
            BagWithLinkedList.Node<Item> last = first;
            while (null != last.next){
                last = last.next;
                retVal.append(",");
                retVal.append(last.item.toString());
            }
        }
        return retVal.toString();
    }

    /**
     * Returns an iterator that iterates over the items in this bag in arbitrary order.
     *
     * @return an iterator that iterates over the items in this bag in arbitrary order
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator(first);
    }

    private class ListIterator implements Iterator<Item>{

        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException("There is no more elements in bag!");
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
