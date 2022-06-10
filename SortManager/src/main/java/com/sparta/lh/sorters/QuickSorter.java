package com.sparta.lh.sorters;

public class QuickSorter implements Sorter {

    public int[] sortArray(int[] arrayToSort) {
        quickSort(arrayToSort, 0, arrayToSort.length - 1);
        return arrayToSort;
    }


    private void quickSort(int[] arrayToSort, int begin, int end) {
        int asc = begin;
        int desc = end;
        int pivot = arrayToSort[begin + (end - begin)/2];

        while(asc <= desc) {
            while(arrayToSort[asc] < pivot) {
                asc++;
            }
            while(arrayToSort[desc] > pivot) {
                desc--;
            }
            if (asc <= desc) {
                swapNumbers(arrayToSort, asc, desc);
                asc++;
                desc--;
            }
        }
        if (begin < desc)
            quickSort(arrayToSort, begin, desc);
        if (asc < end)
            quickSort(arrayToSort, asc, end);
    }

    private void swapNumbers(int[] arrayToSort, int smallerNum, int largerNum) {
        int tempHolder = arrayToSort[smallerNum];
        arrayToSort[smallerNum] = arrayToSort[largerNum];
        arrayToSort[largerNum] = tempHolder;
    }

    @Override
    public String toString() {
        return "Quick Sorter";
    }
}