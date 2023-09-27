package com.tertei.impl;

import com.tertei.interfaces.Stack;

import java.util.NoSuchElementException;

public class StackWithLinkedList<Item> implements Stack<Item> {

    private Node<Item> first;
    private int n; // size of Stack

    private static class Node<Item>{
        final Item item;
        final Node<Item> next;

//        @Contract(pure = true)
        private Node(Item item, Node<Item> node) {
            this.item = item;
            this.next = node;
        }
    }

    public StackWithLinkedList() {
        first = null;
        n = 0;
    }

    @Override
    public void push(Item item) {
        Node<Item> previousItem = first;
        first = new Node<>(item, previousItem);
        n++;
    }

    @Override
    public Item pop() {
        if(n == 0){
            throw new NoSuchElementException("Stack underflow");
        }
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    @Override
    public Item peek() {
        if(n == 0){
            throw new NoSuchElementException("Stack underflow");
        }
        return first.item;
    }

    @Override
    public int size(){
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public String toString(){
        StringBuilder retVal = new StringBuilder();
        if (!isEmpty()){
            retVal.append(first.item.toString());
            Node<Item> last = first;
            while (last.next != null){
                last = last.next;
                retVal.append(",");
                retVal.append(last.item.toString());
            }
        }
        return retVal.toString();
    }
}
