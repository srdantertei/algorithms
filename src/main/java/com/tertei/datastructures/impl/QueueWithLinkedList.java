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
 * This implementation of Queue interface uses a singly linked list with a static nested class for
 * linked-list nodes.
 * <p>
 * The <em>enqueue</em>, <em>dequeue</em>, <em>peek</em>, <em>size</em>, and <em>is-empty</em>
 * operations all take constant time in the worst case.
 * The <em>toString</em> operation takes linear time in the worst case.
 *
 * @param <Item>
 */

public class QueueWithLinkedList<Item> implements Queue<Item> {

    Node<Item> first;
    Node<Item> last;
    int n; // number of elements in queue

    // helper linked list class
    private static class Node<Item>{
        private final Item item;
        private Node<Item> next;

        public Node(Item item){
            this.item = item;
            this.next = null;
        }
    }

    /**
     * Adds the item to this queue.
     *
     * @param  item the item to add
     */
    @Override
    public void enqueue(Item item) {
        if(isEmpty()){
            last = new Node<>(item);
            first = last;
        } else {
            Node<Item> oldLast = last;
            last = new Node<>(item);
            oldLast.next = last;
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
        Item item = first.item;
        first = first.next;
        if(n == 1){
            last = null;
        }
        n--;
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
        return first.item;
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
        Node<Item> node = first;
        s.append(node.item);
        while(node.next != null){
            node = node.next;
            s.append(",");
            s.append(node.item);
        }
        return s.toString();
    }
}
