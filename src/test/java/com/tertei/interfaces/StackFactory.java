package com.tertei.interfaces;

import com.tertei.impl.StackWIthArray;
import com.tertei.impl.StackWithLinkedList;

public class StackFactory<Item> {

    public Stack<Item> getStack(String stackType){
        if(stackType == null)
            return null;
        if(stackType.equalsIgnoreCase("withLinkedList"))
            return new StackWithLinkedList<>();
        else if(stackType.equalsIgnoreCase("withArray"))
            return new StackWIthArray<>();
        else return null;
    }
}
