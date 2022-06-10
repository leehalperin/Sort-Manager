package com.sparta.lh.display;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class SortChoiceMenu {

    public static void mainScreen() {
        System.out.println("Welcome to Lee's Sort Manager! " +
                "\n\nThis program will sort a randomly generated array by your choice of sorter " +
                "\nPlease press enter to continue...");
    }
    public static void pressEnterToContinue()
    {
        Scanner s = new Scanner(System.in);
        s.nextLine();
    }

    static Scanner scanner = new Scanner(System.in);
    static int sortChoice;

    public static ArrayList<String> getMenuItems() {
        return new ArrayList<>(Arrays.asList(
                "Binary Sorter",
                "Bubble Sorter",
                "Insertion Sorter",
                "Java Built In Sorter",
                "Merge Sorter",
                "Quick Sorter",
                "Exit Program"));
    }

    public static void sortChoices() {
        System.out.println("Please enter a number 1-6 to select which sorter to use: ");
        for (int i = 0; i < getMenuItems().size(); i++) {
            System.out.println(i + 1 + ". " + getMenuItems().get(i));
        }
    }
}