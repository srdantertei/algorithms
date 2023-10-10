package com.tertei.tests.datastructures.interfaces;

import com.tertei.datastructures.impl.QueueWithArray;
import com.tertei.datastructures.impl.QueueWithLinkedList;
import com.tertei.datastructures.interfaces.Queue;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class QueueUnitTests {

    private static final String EXPECTED_TRUE = "Expected returned value for method isEmpty is true, but it returned false!";
    private static final String EXPECTED_FALSE = "Expected returned value for method isEmpty is false, but it returned true!";
    private static final String EXPECTED_QUEUE_SIZE = "Expected queue size is %d but actual value is %d";
    private static final String EXPECTED_VALUE = "Expected value is %d but actual is %d";
    private static final String EXPECTED_NO_SUCH_ELEMENT_EXCEPTION = "Expected NoSuchElementException to be thrown!";

    // Types of queue implementations
    private final String[] queueTypes= {"withLinkedList", "withArray"};

    /**
     * Queue initialization tests
     */
    @Test
    public void testInitialization(){
        final QueueUnitTests.QueueFactory<Integer> queueFactory = new QueueUnitTests.QueueFactory<>();
        for (final String queueType: this.queueTypes) {
            final Queue<Integer> queue = queueFactory.getQueue(queueType);//new StackWithLinkedList<>();
            assertNotNull(queue, "StackFactory didn't returned instance of a class!!");
            assertEquals(0, queue.size(), String.format(EXPECTED_QUEUE_SIZE, 0, queue.size()));
            assertThrows(NoSuchElementException.class, queue::dequeue, EXPECTED_NO_SUCH_ELEMENT_EXCEPTION);
            assertThrows(NoSuchElementException.class, queue::peek, EXPECTED_NO_SUCH_ELEMENT_EXCEPTION);
            assertTrue(queue.isEmpty(), EXPECTED_TRUE);
        }
    }

    /**
     * Testing Queue data structure
     */
    @Test
    public void testHappyPath(){
        final QueueUnitTests.QueueFactory<Integer> queueFactory = new QueueUnitTests.QueueFactory<>();
        for (final String queueType: this.queueTypes) {
            final Queue<Integer> queue = queueFactory.getQueue(queueType);
            assertNotNull(queue, "StackFactory didn't returned instance of a class!!");
            assertEquals(0, queue.size(), String.format(QueueUnitTests.EXPECTED_QUEUE_SIZE, 0, queue.size()));
            assertThrows(NoSuchElementException.class, queue::dequeue, EXPECTED_NO_SUCH_ELEMENT_EXCEPTION);
            assertThrows(NoSuchElementException.class, queue::peek, EXPECTED_NO_SUCH_ELEMENT_EXCEPTION);
            assertTrue(queue.isEmpty(), QueueUnitTests.EXPECTED_TRUE);
            System.out.println(queue);
            queue.enqueue(5);
            assertEquals(1, queue.size(), String.format(QueueUnitTests.EXPECTED_QUEUE_SIZE, 1, queue.size()));
            assertEquals(5, queue.peek(), String.format(QueueUnitTests.EXPECTED_VALUE, 5, queue.peek()));
            assertFalse(queue.isEmpty(), QueueUnitTests.EXPECTED_FALSE);
            System.out.println(queue);
            queue.enqueue(6);
            assertEquals(2, queue.size(), String.format(QueueUnitTests.EXPECTED_QUEUE_SIZE, 2, queue.size()));
            assertEquals(5, queue.peek(), String.format(QueueUnitTests.EXPECTED_VALUE, 5, queue.peek()));
            assertFalse(queue.isEmpty(), QueueUnitTests.EXPECTED_FALSE);
            System.out.println(queue);
            queue.enqueue(7);
            assertEquals(3, queue.size(), String.format(QueueUnitTests.EXPECTED_QUEUE_SIZE, 3, queue.size()));
            assertEquals(5, queue.peek(), String.format(QueueUnitTests.EXPECTED_VALUE, 5, queue.peek()));
            assertFalse(queue.isEmpty(), QueueUnitTests.EXPECTED_FALSE);
            System.out.println(queue);
            int dequeueInt = queue.dequeue();
            assertEquals(5, dequeueInt, String.format(QueueUnitTests.EXPECTED_VALUE, 5, dequeueInt));
            assertEquals(2, queue.size(), String.format(QueueUnitTests.EXPECTED_QUEUE_SIZE, 2, queue.size()));
            assertEquals(6, queue.peek(), String.format(QueueUnitTests.EXPECTED_VALUE, 6, queue.peek()));
            assertFalse(queue.isEmpty(), QueueUnitTests.EXPECTED_FALSE);
            System.out.println(queue);
            queue.enqueue(8);
            assertEquals(3, queue.size(), String.format(QueueUnitTests.EXPECTED_QUEUE_SIZE, 3, queue.size()));
            assertEquals(6, queue.peek(), String.format(QueueUnitTests.EXPECTED_VALUE, 6, queue.peek()));
            assertFalse(queue.isEmpty(), QueueUnitTests.EXPECTED_FALSE);
            System.out.println(queue);
            dequeueInt = queue.dequeue();
            assertEquals(6, dequeueInt, String.format(QueueUnitTests.EXPECTED_VALUE, 6, dequeueInt));
            assertEquals(2, queue.size(), String.format(QueueUnitTests.EXPECTED_QUEUE_SIZE, 2, queue.size()));
            assertEquals(7, queue.peek(), String.format(QueueUnitTests.EXPECTED_VALUE, 7, queue.peek()));
            assertFalse(queue.isEmpty(), QueueUnitTests.EXPECTED_FALSE);
            System.out.println(queue);
            dequeueInt = queue.dequeue();
            assertEquals(7, dequeueInt, String.format(QueueUnitTests.EXPECTED_VALUE, 7, dequeueInt));
            assertEquals(1, queue.size(), String.format(QueueUnitTests.EXPECTED_QUEUE_SIZE, 1, queue.size()));
            assertEquals(8, queue.peek(), String.format(QueueUnitTests.EXPECTED_VALUE, 8, queue.peek()));
            assertFalse(queue.isEmpty(), QueueUnitTests.EXPECTED_FALSE);
            System.out.println(queue);
            dequeueInt = queue.dequeue();
            assertEquals(8, dequeueInt, String.format(QueueUnitTests.EXPECTED_VALUE, 8, dequeueInt));
            assertEquals(0, queue.size(), String.format(QueueUnitTests.EXPECTED_QUEUE_SIZE, 0, queue.size()));
            assertThrows(NoSuchElementException.class, queue::peek, EXPECTED_NO_SUCH_ELEMENT_EXCEPTION);
            assertTrue(queue.isEmpty(), QueueUnitTests.EXPECTED_TRUE);
            System.out.println(queue);
            assertThrows(NoSuchElementException.class, queue::dequeue, EXPECTED_NO_SUCH_ELEMENT_EXCEPTION);
        }
    }

    // Factory design pattern: returns instance of implementation class depending on input parameter
    private static class QueueFactory<Item> {
        private Queue<Item> getQueue(final String queueType){
            if(null == queueType)
                return null;
            if("withLinkedList".equalsIgnoreCase(queueType))
                return new QueueWithLinkedList<>();
            else if("withArray".equalsIgnoreCase(queueType))
                return new QueueWithArray<>();
            else return null;
        }
    }
}
