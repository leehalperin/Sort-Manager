package com.sparta.lh;

import com.sparta.lh.exceptions.SortLoaderException;
import com.sparta.lh.sorters.*;
import com.sparta.lh.sorters.binarytree.BinaryTreeSorter;
import com.sparta.lh.start.SortFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;


public class PerformanceTester {
    private static int [] arrayToSort;
    private static int[] unsortedArray;
    
    @BeforeAll
    public static void setClass() {
        Random random = new Random();
        arrayToSort = new int[100];
        for (int i = 0; i < 100; i++) {
            arrayToSort[i] = random.nextInt(1000) + 1;
        }

        Sorter sorter = new JavaSorter();
        unsortedArray = arrayToSort.clone();
        int[] sortedArray = sorter.sortArray(arrayToSort);
        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
        System.out.println("\nSee the time taken by the sorters below: \n");
    }

    @BeforeEach
    public void setup() {
       unsortedArray = arrayToSort.clone();
    }

@Test
    public void testBinarySorter() {
    Sorter sorter = new BinaryTreeSorter();
    long start = System.nanoTime();
    int[] sortedArray = sorter.sortArray(unsortedArray);
    long end = System.nanoTime();
    System.out.print("Binary Sorter: ");
    System.out.println(end-start + " nanoseconds");
    }

    @Test
    public void testBubbleSorter() {
        Sorter sorter = new BubbleSorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        System.out.print("Bubble Sorter: ");
        System.out.println(end-start + " nanoseconds");
    }

    @Test
    public void testInsertionSorter() {
        Sorter sorter = new InsertionSorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        System.out.print("Insertion Sorter: ");
        System.out.println(end-start + " nanoseconds");
    }

    @Test
    public void testJavaSorter() {
        Sorter sorter = new JavaSorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        System.out.print("Java Sorter: ");
        System.out.println(end-start + " nanoseconds");
    }
    @Test
    public void testMergeSorter() {
        Sorter sorter = new MergeSorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        System.out.print("Merge Sorter: ");
        System.out.println(end-start + " nanoseconds");
    }
    @Test
    public void testQuickSorter() {
        Sorter sorter = new QuickSorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        System.out.print("Quick Sorter: ");
        System.out.println(end-start + " nanoseconds");
    }

}
