package com.example.solutions.hackern;

import java.util.List;
import java.util.ArrayList;

public class Trucks {

    public static void main(String[] args) {
        // Example listOfLists
        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(List.of(3, 1));
        listOfLists.add(List.of(2, 4));
        listOfLists.add(List.of(5, 2));

        int startingPoint = 0;
        int iteration = 0;
        int leftOver = 0;
        boolean found = false;

        while (!found) {
            List<Integer> list = listOfLists.get(iteration);
            leftOver += list.get(0) - list.get(1);

            if (leftOver > 0) {
                iteration = (iteration + 1) % listOfLists.size();
                if (iteration == startingPoint) {
                    System.out.println("Found at iteration: " + iteration);
                    found = true;
                }
            } else {
                startingPoint = (startingPoint + 1) % listOfLists.size();
                iteration = startingPoint;
                leftOver = 0;
            }
        }
    }
}
