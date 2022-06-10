package com.sparta.lh.display;

import com.sparta.lh.sorters.Sorter;

import java.util.Arrays;

public class Results {

    public static void printBeforeSort(Sorter sorter, int[] arrayToSort) {
        System.out.println("Sorted using the " + sorter);
        System.out.println("Before sorting:\n" + Arrays.toString(arrayToSort));
    }

    public static void printResults(Sorter sorter, int[] arrayToSort) {
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(arrayToSort);
        System.out.println("After sorting:\n" + Arrays.toString(sortedArray));
        long end = System.nanoTime();
        System.out.println("Time taken: " + (end - start) + "nanoseconds");
    }
}