package com.sparta.lh.sorters;


public class BubbleSorter implements Sorter {

    public int[] sortArray(int[] arrayToSort) {

        return bubbleSort(arrayToSort);
    }

    private int[] bubbleSort(int[] arrayToSort) {
        int n = arrayToSort.length;
        int t = 0;
        for (int i = 0; i < arrayToSort.length; i++) {
            for (int j = 1; j < (arrayToSort.length - i); j++) {
                if (arrayToSort[j - 1] > arrayToSort[j]) {
                    t = arrayToSort[j - 1];
                    arrayToSort[j - 1] = arrayToSort[j];
                    arrayToSort[j] = t;
                }
            }
        }
        return arrayToSort;
    }

    @Override
    public String toString() {
        return "Bubble Sorter";
    }
}