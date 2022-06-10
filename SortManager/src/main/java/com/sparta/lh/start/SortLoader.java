package com.sparta.lh.start;

import com.sparta.lh.display.Results;
import com.sparta.lh.display.SortChoiceMenu;
import com.sparta.lh.exceptions.SortLoaderException;
import com.sparta.lh.sorters.Sorter;

import java.util.Random;
import java.util.Scanner;

public class SortLoader {
    private final static Scanner scanner = new Scanner(System.in);

    public static void start() {

        SortChoiceMenu.mainScreen();
        SortChoiceMenu.pressEnterToContinue();
        int menuChoice = 0;
        while (menuChoice != 7) {
            try {

                SortChoiceMenu.sortChoices();
                menuChoice = scanner.nextInt();
                Sorter sorter = SortFactory.chooseSorter(menuChoice);
                System.out.println("Please enter the length of the array you wish to generate:");
                int arrayLength = scanner.nextInt();
                int[] arrayToSort = createArray(arrayLength);
                Results.printBeforeSort(sorter, arrayToSort);
                Results.printResults(sorter, arrayToSort);
            } catch (SortLoaderException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int[] createArray(int size) {
        Random random = new Random();
        int[] unsortedArray = new int[size];
        for (int i = 0; i < size; i++) {
            unsortedArray[i] = random.nextInt(size * 10) + 1;
        }
        return unsortedArray;
    }
}