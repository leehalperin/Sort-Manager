package com.sparta.lh.start;

import com.sparta.lh.exceptions.SortLoaderException;
import com.sparta.lh.sorters.*;
import com.sparta.lh.sorters.binarytree.BinaryTreeSorter;

public class SortFactory {

    public static Sorter chooseSorter(int menuChoice) throws SortLoaderException {
        switch (menuChoice) {
            case 1:
                return new BinaryTreeSorter();
            case 2:
                return new BubbleSorter();
            case 3:
                return new InsertionSorter();
            case 4:
                return new JavaSorter();
            case 5:
                return new MergeSorter();
            case 6:
                return new QuickSorter();
            case 7:
                System.out.println("Exiting Program...");
                System.exit(0);
            default:
                throw new SortLoaderException(menuChoice + " is an invalid input.");

        }
    }
}