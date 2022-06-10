package com.sparta.lh;

import com.sparta.lh.exceptions.SortLoaderException;
import com.sparta.lh.sorters.Sorter;
import com.sparta.lh.start.SortFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class SortTester {

    private static Sorter sorter;
    private int[] arrayToSort;



    @BeforeAll
    static void setClass() throws SortLoaderException {
        sorter = SortFactory.chooseSorter(3);
        System.out.println("Testing with " + sorter);
    }

    @BeforeEach
    public void setup() {
        Random random = new Random();
        arrayToSort = new int[10];
        for (int i = 0; i < 10; i++) {
            arrayToSort[i] = random.nextInt(100) + 1;
        }
    }

    @Test
    public void testInvalidSorterSelectionThrowsSortLoaderException() {
        SortLoaderException thrown = Assertions.assertThrows(SortLoaderException.class, () -> {
            sorter = SortFactory.chooseSorter(10);
        });
    }

    @Test
    public void testNullArrayThrowsNullException() {
        NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
            int[] arrayToSort = null;
            int[] sortedArray = sorter.sortArray(arrayToSort);
        });
    }

    @Test
    public void testArrayIsSorted() {
        int[] arrayToSort = sorter.sortArray(this.arrayToSort);
        for (int i = 0; i< arrayToSort.length-1; i++){
            Assertions.assertTrue(arrayToSort[i+1] >= arrayToSort[i]);
        }
    }
    @Test
    public void testOddSizedArray() {
        int[] arrayToSort = {4,7,1,};
        int[] sortedArray = sorter.sortArray(arrayToSort);
        Assertions.assertEquals(1,sortedArray.length%2);
    }

    @Test
    public void testEvenSizedArray() {
        int[] arrayToSort = {7,5,43,9,2,1,6,77,12,21};
        int[] sortedArray = sorter.sortArray(arrayToSort);
        Assertions.assertEquals(0,sortedArray.length%2);

    }
    @Test
    public void testArrayWithSameNumbers() {
        int[] arrayToSort = {5,5,5,5};
        int[] sortedArray = sorter.sortArray(arrayToSort);
        Assertions.assertEquals(sortedArray.length, arrayToSort.length);
        for (int i=0;i<sortedArray.length-1;i++){
            Assertions.assertTrue(sortedArray[i+1]  >=sortedArray[i]);
        }
    }

    @Test
    public void testAlreadySortedArray() {
        int[] arrayToSort = {4,6,10,24,55};
        int[] sortedArray = sorter.sortArray(arrayToSort);
        Assertions.assertEquals(sortedArray.length, arrayToSort.length);
        Assertions.assertEquals(sortedArray, arrayToSort);
    }

    @Test
    public void testSingleElementArray() {
        int[] arrayToSort = {4};
        int[] sortedArray = sorter.sortArray(arrayToSort);
        Assertions.assertEquals(sortedArray.length, arrayToSort.length);
        Assertions.assertEquals(sortedArray, arrayToSort);
        }

    @Test
    public void testAllZeroArray() {
        int[] arrayToSort = {0,0,0,0,0,0,0};
        int[] sortedArray = sorter.sortArray(arrayToSort);
        Assertions.assertEquals(sortedArray.length, arrayToSort.length);
        Assertions.assertEquals(sortedArray, arrayToSort);
        }

    @Test
    public void testArrayWithNegativeValues() {
        int[] arrayToSort = {-4,7,-8,88,15};
        int[] sortedArray = sorter.sortArray(arrayToSort);
        Assertions.assertEquals(sortedArray.length, arrayToSort.length);
        Assertions.assertEquals(sortedArray [0], -8);
        Assertions.assertEquals(sortedArray [4], 88);
        }
    }

