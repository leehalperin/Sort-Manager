package com.sparta.lh.sorters;

import java.util.Arrays;

public class MergeSorter implements Sorter{


    public int[] sortArray(int[] arrayToSort) {
        mergeSort(arrayToSort,0,arrayToSort.length - 1);
        return arrayToSort;
    }

    public void merge(int[] arrayToMerge, int startingIndex, int middleIndex, int endingIndex) {
        int leftArray[] = new int[middleIndex - startingIndex + 1];
        int rightArray[] = new int[endingIndex - middleIndex];

        for (int i = 0; i < leftArray.length; i++)
            leftArray[i] = arrayToMerge[startingIndex + i];
        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = arrayToMerge[middleIndex + i + 1];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = startingIndex; i < endingIndex + 1; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    arrayToMerge[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    arrayToMerge[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                arrayToMerge[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                arrayToMerge[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    public void mergeSort(int[] array, int startIndexNum, int endIndexNum) {
        if (endIndexNum > startIndexNum) {
            int midIndexNum = (startIndexNum + endIndexNum) / 2;
            mergeSort(array, startIndexNum, midIndexNum);
            mergeSort(array, midIndexNum + 1, endIndexNum);
            merge(array, startIndexNum, midIndexNum, endIndexNum);
        }
    }

    @Override
    public String toString() {
        return "Merge Sorter";
    }
}


