/**
 * This code is based on information and implementations from the following web page:
 * URL: https://algs4.cs.princeton.edu/code/
 * Authors: Robert Sedgewick, Kevin Wayne
 * Date: September 30, 2023
 * <p>
 * Original source: https://algs4.cs.princeton.edu/code/
 */

package com.tertei.datastructures.impl;

import com.tertei.datastructures.interfaces.Queue;
import java.util.NoSuchElementException;

/**
 *  This implementation uses a resizing array, which double the underlying array
 *  when it is full and halves the underlying array when it is one-quarter full.
 *  <p>
 *  The <em>enqueue</em> and <em>dequeue</em> operations take constant amortized time.
 *  The <em>peek</em>, <em>size</em>, and <em>is-empty</em> operations
 *  all take constant time in the worst case.
 *  The <em>toString</em> operation takes linear time in the worst case.
 *  </p>
 * @param <Item>
 */

public class QueueWithArray<Item> implements Queue<Item> {

    private int head;  // dequeue item from head
    private int tail;  // enqueue new item on tail
    private Item[] a;  // array of items
    private int n; // size of queue

    /**
     * Initializes an empty queue.
     */
    @SuppressWarnings("unchecked")
    public QueueWithArray(){
        a = (Item[])new Object[2];
        head = 0;
        tail = 0;
    }

    /**
     * Adds the item to this queue.
     *
     * @param  item the item to add
     */
    @Override
    public void enqueue(Item item) {
        if(a.length == n){
            resize(a.length * 2);
        }
        a[tail] = item;
        tail++;
        if(tail == a.length){
            tail = 0;
        }
        n++;
    }

    /**
     * Removes and returns the item least recently added to this queue.
     *
     * @return the item least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public Item dequeue() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException("Queue underflow!");
        }
        Item item = a[head];
        a[head] = null; // to avoid loitering
        head++;
        if(head == a.length){
            head = 0;
        }
        n--;
        if(n == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    /**
     * Returns (but does not remove) the item least recently added to this queue.
     *
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public Item peek() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException("Queue underflow!");
        }
        return a[head];
    }

    /**
     * Returns true if this queue is empty.
     *
     * @return true if this queue is empty; false otherwise
     */
    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    @Override
    public int size() {
        return n;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in this queue in FIFO order, separated by spaces
     */
    @Override
    public String toString(){
        if(isEmpty()){
            return "Empty queue";
        }
        StringBuilder s = new StringBuilder();
        if(head + n <= a.length) {
            for (int i = head; i < n + head; i++) {
                s.append(a[i].toString());
                s.append(" ");
            }
        } else {
            for (int i = head; i < a.length; i++) {
                s.append(a[i].toString());
                s.append(" ");
            }
            for (int i = 0; i < n + head - a.length; i++) {
                s.append(a[i].toString());
                s.append(" ");
            }
        }
        return s.toString();
    }

    // resize the underlying array holding the elements
    @SuppressWarnings("unchecked")
    private void resize(int capacity){
        Item[] resizedArray = (Item[])new Object[capacity];
        for(int i = 0; i < n; i++){
            resizedArray[i] = a[(head + i) % a.length];
        }
        a = resizedArray;
        head = 0;
        tail = n;
    }
}
