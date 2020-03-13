package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {
    ArrayList<Integer> evenList = new ArrayList<>();

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {
        for (Integer element : numbers) {
            if (element % 2 == 0) {
                evenList.add(element);
            }
        }
        return evenList;
    }
}
