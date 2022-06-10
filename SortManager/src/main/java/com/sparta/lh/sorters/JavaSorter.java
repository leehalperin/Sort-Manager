package com.sparta.lh.sorters;

import java.util.Arrays;

public class JavaSorter implements Sorter{


    public int[] sortArray(int[] arrayToSort) {
        Arrays.sort(arrayToSort);
        return arrayToSort;
    }


    @Override
    public String toString() {
        return "Java Built In Sorter";
    }
}
