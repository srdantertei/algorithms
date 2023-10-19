package com.tertei.tests.sorts.interfaces;

import com.tertei.sorts.impl.InsertionSort;
import com.tertei.sorts.impl.MergeSort;
import com.tertei.sorts.impl.QuickSort;
import com.tertei.sorts.impl.SelectionSort;
import com.tertei.sorts.interfaces.Sortable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortableUnitTests {

    // Types of sort algorithms
    private final String[] sortAlgorithms= {"SelectionSort","InsertionSort","MergeSort","QuickSort"};

    // Object that implements comparable interface
    private class SortItem implements Comparable<SortItem>{
        private final int key;

        public SortItem(int key) {
            this.key = key;
        }

        @Override
        public int compareTo(SortItem o) {
            if (this.key < o.key)
                return -1;
            if (this.key > o.key)
                return 1;
            return 0;
        }
    }

    // array that has to be sorted
    private SortItem[] testArray;

    @BeforeEach
    public void initializeArray(){
        testArray = new SortItem[]{new SortItem(5), new SortItem(2), new SortItem(8),  new SortItem(10), new SortItem(1),  new SortItem(8), new SortItem(6), new SortItem(7),  new SortItem(9),  new SortItem(1), new SortItem(3), new SortItem(4)};
    }

    /**
     * Testing sorting algorithms
     */
    @Test
    public void testSorts(){
        final SortableFactory<SortItem> sortableFactory = new SortableFactory<>();
        for(String sortAlgorithm : sortAlgorithms) {
            System.out.println("Tested algorithm: " + sortAlgorithm);
            Sortable sorter = sortableFactory.getSortable(sortAlgorithm);
            sorter.sort(testArray);
            assertTrue(isSorted(testArray));
        }
    }

    // Factory design pattern: returns instance of implementation class depending on input parameter
    private static class SortableFactory<Item extends Comparable<Item>>{
        private Sortable getSortable(final String sortableName){
            if(null == sortableName)
                return null;
            if("SelectionSort".equalsIgnoreCase(sortableName))
                return new SelectionSort();
            if("InsertionSort".equalsIgnoreCase(sortableName))
                return new InsertionSort();
            if("MergeSort".equalsIgnoreCase(sortableName))
                return new MergeSort();
            if("QuickSort".equalsIgnoreCase(sortableName))
                return new QuickSort();
            else return null;
        }
    }

    // test if array is sorted
    static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // helper method for isSorted test
    static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
}
