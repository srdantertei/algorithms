package com.tertei.tests.datastructures.interfaces;

import com.tertei.datastructures.impl.StackWithArray;
import com.tertei.datastructures.impl.StackWithLinkedList;
import com.tertei.datastructures.interfaces.Stack;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

/**
 *  Class with unit tests for using Stack interface with all implementation classes which are injected using Factory design pattern
 */
class StackUnitTests {

    private static final String EXPECTED_TRUE = "Expected returned value for method isEmpty is true, but it returned false!";
    private static final String EXPECTED_FALSE = "Expected returned value for method isEmpty is false, but it returned true!";
    private static final String EXPECTED_STACK_SIZE = "Expected stack size is %d but actual value is %d";
    private static final String EXPECTED_VALUE = "Expected value is %d but actual is %d";
    private static final String EXPECTED_NO_SUCH_ELEMENT_EXCEPTION = "Expected NoSuchElementException to be thrown!";

    // Types of stack implementations
    private final String[] stackTypes= {"withLinkedList", "withArray"};

    /**
     * Stack initialization tests
     */
    @Test
    public void testInitialization(){
        final StackFactory<Integer> stackFactory = new StackFactory<>();
        for (final String stackType: this.stackTypes) {
            final Stack<Integer> stack = stackFactory.getStack(stackType);//new StackWithLinkedList<>();
            assertNotNull(stack, "StackFactory didn't returned instance of a class!!");
            assertEquals(0, stack.size(), String.format(EXPECTED_STACK_SIZE, 0, stack.size()));
            assertThrows(NoSuchElementException.class, stack::pop, EXPECTED_NO_SUCH_ELEMENT_EXCEPTION);
            assertThrows(NoSuchElementException.class, stack::peek, EXPECTED_NO_SUCH_ELEMENT_EXCEPTION);
            assertTrue(stack.isEmpty(), EXPECTED_TRUE);
        }
    }

    /**
     * Testing Stack data structure
     */
    @Test
    public void testHappyPath(){
        final StackFactory<Integer> stackFactory = new StackFactory<>();
        for (final String stackType: this.stackTypes) {
            final Stack<Integer> stack = stackFactory.getStack(stackType);
            assertNotNull(stack, "StackFactory didn't returned instance of a class!!");
            assertEquals(0, stack.size(), String.format(StackUnitTests.EXPECTED_STACK_SIZE, 0, stack.size()));
            assertThrows(NoSuchElementException.class, stack::pop, EXPECTED_NO_SUCH_ELEMENT_EXCEPTION);
            assertThrows(NoSuchElementException.class, stack::peek, EXPECTED_NO_SUCH_ELEMENT_EXCEPTION);
            assertTrue(stack.isEmpty(), StackUnitTests.EXPECTED_TRUE);
            System.out.println(stack);
            stack.push(5);
            assertEquals(1, stack.size(), String.format(StackUnitTests.EXPECTED_STACK_SIZE, 1, stack.size()));
            assertEquals(5, stack.peek(), String.format(StackUnitTests.EXPECTED_VALUE, 5, stack.peek()));
            assertFalse(stack.isEmpty(), StackUnitTests.EXPECTED_FALSE);
            System.out.println(stack);
            stack.push(6);
            assertEquals(2, stack.size(), String.format(StackUnitTests.EXPECTED_STACK_SIZE, 2, stack.size()));
            assertEquals(6, stack.peek(), String.format(StackUnitTests.EXPECTED_VALUE, 6, stack.peek()));
            assertFalse(stack.isEmpty(), StackUnitTests.EXPECTED_FALSE);
            System.out.println(stack);
            stack.push(7);
            assertEquals(3, stack.size(), String.format(StackUnitTests.EXPECTED_STACK_SIZE, 3, stack.size()));
            assertEquals(7, stack.peek(), String.format(StackUnitTests.EXPECTED_VALUE, 7, stack.peek()));
            assertFalse(stack.isEmpty(), StackUnitTests.EXPECTED_FALSE);
            System.out.println(stack);
            int popInt = stack.pop();
            assertEquals(7, popInt, String.format(StackUnitTests.EXPECTED_VALUE, 7, popInt));
            assertEquals(2, stack.size(), String.format(StackUnitTests.EXPECTED_STACK_SIZE, 2, stack.size()));
            assertEquals(6, stack.peek(), String.format(StackUnitTests.EXPECTED_VALUE, 6, stack.peek()));
            assertFalse(stack.isEmpty(), StackUnitTests.EXPECTED_FALSE);
            System.out.println(stack);
            stack.push(8);
            assertEquals(3, stack.size(), String.format(StackUnitTests.EXPECTED_STACK_SIZE, 3, stack.size()));
            assertEquals(8, stack.peek(), String.format(StackUnitTests.EXPECTED_VALUE, 8, stack.peek()));
            assertFalse(stack.isEmpty(), StackUnitTests.EXPECTED_FALSE);
            System.out.println(stack);
            popInt = stack.pop();
            assertEquals(8, popInt, String.format(StackUnitTests.EXPECTED_VALUE, 8, popInt));
            assertEquals(2, stack.size(), String.format(StackUnitTests.EXPECTED_STACK_SIZE, 2, stack.size()));
            assertEquals(6, stack.peek(), String.format(StackUnitTests.EXPECTED_VALUE, 6, stack.peek()));
            assertFalse(stack.isEmpty(), StackUnitTests.EXPECTED_FALSE);
            System.out.println(stack);
            popInt = stack.pop();
            assertEquals(6, popInt, String.format(StackUnitTests.EXPECTED_VALUE, 6, popInt));
            assertEquals(1, stack.size(), String.format(StackUnitTests.EXPECTED_STACK_SIZE, 1, stack.size()));
            assertEquals(5, stack.peek(), String.format(StackUnitTests.EXPECTED_VALUE, 5, stack.peek()));
            assertFalse(stack.isEmpty(), StackUnitTests.EXPECTED_FALSE);
            System.out.println(stack);
            popInt = stack.pop();
            assertEquals(5, popInt, String.format(StackUnitTests.EXPECTED_VALUE, 5, popInt));
            assertEquals(0, stack.size(), String.format(StackUnitTests.EXPECTED_STACK_SIZE, 0, stack.size()));
            assertThrows(NoSuchElementException.class, stack::peek, EXPECTED_NO_SUCH_ELEMENT_EXCEPTION);
            assertTrue(stack.isEmpty(), StackUnitTests.EXPECTED_TRUE);
            System.out.println(stack);
            assertThrows(NoSuchElementException.class, stack::pop, EXPECTED_NO_SUCH_ELEMENT_EXCEPTION);
        }
    }

    // Factory design pattern: returns instance of implementation class depending on input parameter
    private static class StackFactory<Item> {
        private Stack<Item> getStack(final String stackType){
            if(null == stackType)
                return null;
            if("withLinkedList".equalsIgnoreCase(stackType))
                return new StackWithLinkedList<>();
            else if("withArray".equalsIgnoreCase(stackType))
                return new StackWithArray<>();
            else return null;
        }
    }
}
