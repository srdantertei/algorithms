package com.tertei.impl;

import com.tertei.interfaces.Stack;

import java.util.NoSuchElementException;

public class StackWIthArray<Item> implements Stack<Item> {

    private Item[] a;
    private int n;

    @SuppressWarnings("unchecked")
    public StackWIthArray(){
        a = (Item[]) new Object[2];
        n = 0;
    }

    @Override
    public void push(Item item) {
        if(n == a.length){
            resize(a.length*2);
        }
        a[n] = item;
        n++;
    }

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

    @Override
    public Item peek() {
        if(isEmpty()){
            throw new NoSuchElementException("Stack underflow!");
        }
        return a[n-1];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < n; i++){
            s.append(a[i].toString());
            s.append(" ");
        }
        return s.toString();
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity){
        Item[] copy = (Item[])new Object[capacity];
        if (n >= 0) System.arraycopy(a, 0, copy, 0, n);
        a = copy;
    }

}
