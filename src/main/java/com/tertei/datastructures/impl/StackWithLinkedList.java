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
 * This implementation of Stack interface uses a singly linked list with a static nested class for
 * linked-list nodes.
 * <p>
 * The <em>push</em>, <em>pop</em>, <em>peek</em>, <em>size</em>, and <em>is-empty</em>
 * operations all take constant time in the worst case.
 * The <em>toString</em> operation takes linear time in the worst case.
 *
 * @param <Item>
 */

public class StackWithLinkedList<Item> implements Stack<Item> {

    private Node<Item> first; // top of stack
    private int n; // number of elements on stack

    // helper linked list class
    private static class Node<Item>{
        private final Item item;
        private final Node<Item> next;

//        @Contract(pure = true)
        private Node(Item item, Node<Item> node) {
            this.item = item;
            this.next = node;
        }
    }

    /**
     * Initializes an empty stack.
     */
    public StackWithLinkedList() {
        first = null;
        n = 0;
    }

    /**
     * Adds the item to this stack.
     *
     * @param  item the item to add
     */
    @Override
    public void push(Item item) {
        Node<Item> previousItem = first;
        first = new Node<>(item, previousItem);
        n++;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    @Override
    public Item pop() throws NoSuchElementException{
        if(isEmpty()){
            throw new NoSuchElementException("Stack underflow");
        }
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    @Override
    public Item peek() throws NoSuchElementException{
        if(isEmpty()){
            throw new NoSuchElementException("Stack underflow");
        }
        return first.item;
    }

    /**
     * Returns the number of items in this stack.
     *
     * @return the number of items in this stack
     */
    @Override
    public int size(){
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
        StringBuilder retVal = new StringBuilder();
        if (!isEmpty()){
            retVal.append(first.item.toString());
            Node<Item> last = first;
            while (null != last.next){
                last = last.next;
                retVal.append(",");
                retVal.append(last.item.toString());
            }
        }
        return retVal.toString();
    }
}
