package com.tertei.interfaces;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class StackUnitTests {

    private final String[] stackTypes= {"withLinkedList", "withArray"};

    @Test
    public void testInitialization(){
        StackFactory<Integer> stackFactory = new StackFactory<>();
        for (String stackType: stackTypes) {
            Stack<Integer> stack = stackFactory.getStack(stackType);//new StackWithLinkedList<>();
            assertNotNull(stack);
            assertEquals(0, stack.size());
            assertThrows(NoSuchElementException.class, stack::pop);
            assertThrows(NoSuchElementException.class, stack::peek);
            assertTrue(stack.isEmpty());
        }
    }

    @Test
    public void testStackAlgorithmHappyPath(){
        StackFactory<Integer> stackFactory = new StackFactory<>();
        for (String stackType: stackTypes) {
            Stack<Integer> stack = stackFactory.getStack(stackType);
            assertNotNull(stack);
            assertEquals(0, stack.size());
            assertThrows(NoSuchElementException.class, stack::pop);
            assertThrows(NoSuchElementException.class, stack::peek);
            assertTrue(stack.isEmpty());
            System.out.println(stack);
            stack.push(5);
            assertEquals(1, stack.size());
            assertEquals(5, stack.peek());
            assertFalse(stack.isEmpty());
            System.out.println(stack);
            stack.push(6);
            assertEquals(2, stack.size());
            assertEquals(6, stack.peek());
            assertFalse(stack.isEmpty());
            System.out.println(stack);
            stack.push(7);
            assertEquals(3, stack.size());
            assertEquals(7, stack.peek());
            assertFalse(stack.isEmpty());
            System.out.println(stack);
            assertEquals(7, stack.pop());
            assertEquals(2, stack.size());
            assertEquals(6, stack.peek());
            assertFalse(stack.isEmpty());
            System.out.println(stack);
            stack.push(8);
            assertEquals(3, stack.size());
            assertEquals(8, stack.peek());
            assertFalse(stack.isEmpty());
            System.out.println(stack);
            assertEquals(8, stack.pop());
            assertEquals(2, stack.size());
            assertEquals(6, stack.peek());
            assertFalse(stack.isEmpty());
            System.out.println(stack);
            assertEquals(6, stack.pop());
            assertEquals(1, stack.size());
            assertEquals(5, stack.peek());
            assertFalse(stack.isEmpty());
            System.out.println(stack);
            assertEquals(5, stack.pop());
            assertEquals(0, stack.size());
            assertThrows(NoSuchElementException.class, stack::peek);
            assertTrue(stack.isEmpty());
            System.out.println(stack);
            assertThrows(NoSuchElementException.class, stack::pop);
        }
    }
}
