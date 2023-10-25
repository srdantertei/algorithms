package com.tertei.tests.sorts.interfaces;

import com.tertei.sorts.interfaces.Sortable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class SortableUnitTests {

    // Types of sort algorithms
    private final String[] sortAlgorithms= {"com.tertei.sorts.impl.SelectionSort","com.tertei.sorts.impl.InsertionSort","com.tertei.sorts.impl.MergeSort","com.tertei.sorts.impl.QuickSort"};

    // Object that implements comparable interface
    private static class SortItem implements Comparable<SortItem>{
        private final int key;

        public SortItem(int key) {
            this.key = key;
        }

        @Override
        public int compareTo(SortItem o) {
            return Integer.compare(this.key, o.key);
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
        for(String sortAlgorithm : sortAlgorithms) {
            System.out.println("Tested algorithm: " + sortAlgorithm);
            try {
                Class<?> factoryClass = getClassByName(sortAlgorithm);
                if(Sortable.class.isAssignableFrom(factoryClass)){
                    try{
                        // Get the method
                        Method method = factoryClass.getMethod("sort", Comparable[].class);

                        // Invoke the static method with the testArray as parameter
                        method.invoke(null, (Object) testArray);
                    } catch(Exception e){
                        fail();
                    }
                }
            } catch (ClassNotFoundException e) {
                fail();
            }
            assertTrue(isSorted(testArray));
        }
    }

    private static Class<?>  getClassByName(String className) throws ClassNotFoundException {
        return Class.forName(className);
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
