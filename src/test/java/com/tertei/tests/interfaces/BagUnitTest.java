package com.tertei.tests.interfaces;

import com.tertei.impl.BagWithArray;
import com.tertei.impl.BagWithLinkedList;
import com.tertei.interfaces.Bag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  Class with unit tests for using Bag interface with all implementation classes which are injected using Factory design pattern
 */
public class BagUnitTest {
    private static final String EXPECTED_TRUE = "Expected returned value for method isEmpty is true, but it returned false!";
    private static final String EXPECTED_FALSE = "Expected returned value for method isEmpty is false, but it returned true!";
    private static final String EXPECTED_BAG_SIZE = "Expected bag size is %d but actual value is %d";
    private final String[] bagTypes= {"withLinkedList", "withArray"};

    /**
     * Stack initialization tests
     */
    @Test
    public void testInitialization(){
        final BagUnitTest.BagFactory<Integer> bagFactory = new BagUnitTest.BagFactory<>();
        for (final String bagType: this.bagTypes) {
            final Bag<Integer> bag = bagFactory.getBag(bagType);
            assertNotNull(bag, "StackFactory didn't returned instance of a class!!");
            assertEquals(0, bag.size(), String.format(EXPECTED_BAG_SIZE, 0, bag.size()));
            assertTrue(bag.isEmpty(), EXPECTED_TRUE);
        }
    }

    /**
     * Testing Bag data structure
     */
    @Test
    public void testHappyPath(){
        final BagUnitTest.BagFactory<Integer> bagFactory = new BagUnitTest.BagFactory<>();
        for (final String bagType: this.bagTypes) {
            final Bag<Integer> bag = bagFactory.getBag(bagType);
            assertNotNull(bag, "StackFactory didn't returned instance of a class!!");
            assertEquals(0, bag.size(), String.format(EXPECTED_BAG_SIZE, 0, bag.size()));
            assertTrue(bag.isEmpty(), EXPECTED_TRUE);
            System.out.println(bag);
            bag.add(5);
            assertEquals(1, bag.size(), String.format(EXPECTED_BAG_SIZE, 1, bag.size()));
            assertFalse(bag.isEmpty(), EXPECTED_FALSE);
            System.out.println(bag);
            bag.add(7);
            assertEquals(2, bag.size(), String.format(EXPECTED_BAG_SIZE, 2, bag.size()));
            assertFalse(bag.isEmpty(), EXPECTED_FALSE);
            System.out.println(bag);
            bag.add(3);
            assertEquals(3, bag.size(), String.format(EXPECTED_BAG_SIZE, 3, bag.size()));
            assertFalse(bag.isEmpty(), EXPECTED_FALSE);
            System.out.println(bag);
            bag.add(5);
            assertEquals(4, bag.size(), String.format(EXPECTED_BAG_SIZE, 4, bag.size()));
            assertFalse(bag.isEmpty(), EXPECTED_FALSE);
            System.out.println(bag);
            int[] intFromBag = new int[4];
            int i = 0;
            for (Integer integer : bag) {
                intFromBag[i] = integer;
                i++;
            }
            System.out.println(Arrays.toString(intFromBag));
            Arrays.sort(intFromBag);
            System.out.println(Arrays.toString(intFromBag));
            int[] intToCompare = {3,5,5,7};
            assertEquals(Arrays.compare(intToCompare, intFromBag), 0);
        }
    }

    private static class BagFactory<Item> {
        private Bag<Item> getBag(final String bagType){
            if(null == bagType)
                return null;
            if("withLinkedList".equalsIgnoreCase(bagType))
                return new BagWithLinkedList<>();
            else if("withArray".equalsIgnoreCase(bagType))
                return new BagWithArray<>();
            else return null;
        }
    }
}
