package org.example;

import java.util.Arrays;

public class TriBulle implements TriTableau {
    public TriBulle() {

    }
    public int[] trier(int[] myArray) {
        if (myArray == null) {
            return null;
        }
        int temp = 0;
        int counter = 0;

        for (int i = 0; i < myArray.length; i++) {
            counter = i + 1;
            for (int j = 1; j < (myArray.length - i); j++) {

                if (myArray[j - 1] > myArray[j]) {
                    temp = myArray[j - 1];
                    myArray[j - 1] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }
        return myArray;
    }
}
