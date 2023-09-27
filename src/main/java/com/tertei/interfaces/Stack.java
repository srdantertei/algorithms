package com.tertei.interfaces;

public interface Stack<Item> {
    void push(Item item);
    Item pop();
    Item peek();
    int size();
    boolean isEmpty();
    String toString();
}