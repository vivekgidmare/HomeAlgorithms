package com.example;

import java.util.Arrays;

public class MyClass {
    private static final String TAG = MyClass.class.getSimpleName();
    private static int[] array = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    private static int[] selectionSortArray = {61, 67, 71, 73, 2, 3, 53, 59, 79, 83, 89, 97, 5, 7, 11, 13, 37, 41, 43, 47, 17, 19, 23, 29, 31};
    private static int[] insertionArray = {-5, -11, 0, 6, 7, 5};//{22, 11, 99, 88, 9, 7, 42}
    private static int[] mergeArray ={13, -7, 12, 14, 0, -6, 9, 0};// {14, 7, 3, 12, 9, 11, 6, 2};

    public static void main(String[] args) {

        System.out.println("Size :" + array.length);
        //Binary Search Testing
        int result = binarySearch(67);
        System.out.println("\nSearch Result ::" + result);
        int result2 = binarySearch(62);
        System.out.println("Search result2 ::" + result2);

        //Selection sort testing
        System.out.println("\nBefore selection sort\n:" + Arrays.toString(selectionSortArray));
        selectionSort(selectionSortArray);
        System.out.println("After selection sort\n:" + Arrays.toString(selectionSortArray));

        //Insertion sort testing
        System.out.println("\nBefore insertion sort\n:" + Arrays.toString(insertionArray));
        insertionSort(insertionArray);
        System.out.println("After insertion sort\n:" + Arrays.toString(insertionArray));


        //Recursion testing
        System.out.println("\nIterative Factorial\n:" + iterrativeFactorial(5));
        System.out.println("\nRecursive Factorial\n:" + recursiveFactorial(5));

        System.out.println("\nisPalindrome MOTOR :" + isPalindrome("MOTOR"));
        System.out.println("\nisPalindrome ROTOR :" + isPalindrome("ROTOR"));

        System.out.println("\npowerOfNumber 3,2 :" + powerOfNumber(3, 2));


        //Merge sort testing
        System.out.println("\nBefore Merge sort\n:" + Arrays.toString(mergeArray));
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        System.out.println("After Merge sort\n:" + Arrays.toString(mergeArray));
    }


    private static int binarySearch(int input) {
        int min = 0;
        int max = array.length - 1;
        int guess;
        while (max >= min) {
            guess = (int) Math.floor((min + max) / 2);
            if (array[guess] == input)
                return guess;
            if (array[guess] < input) {
                min = guess + 1;
            } else {
                max = guess - 1;
            }
            System.out.println("*" + guess);
        }
        return -1;
    }

    //-------------Selection Sort---------------

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static int indexOfMinimum(int[] array, int startIndex) {
        int minIndex = startIndex;
        int minValue = array[startIndex];
        for (int i = minIndex + 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minIndex = i;
                minValue = array[i];
            }
        }
        return minIndex;
    }

    private static void selectionSort(int[] array) {
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            minIndex = indexOfMinimum(array, i);
            swap(array, minIndex, i);
        }

    }
    //-------------Selection Sort---------------

    //-------------Insertion Sort---------------
    private static void insert(int[] array, int rightIndex, int value) {
        int index = 0;
        for (index = rightIndex; index >= 0 && value < array[index]; index--) {
            array[index + 1] = array[index];
        }
        array[index + 1] = value;
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            insert(array, i - 1, array[i]);
        }
    }
    //-------------Insertion Sort---------------


    //-----------Recursion Related Implementation -----------

    private static int iterrativeFactorial(int value) {
        int result = 1;
        for (int i = value; i > 0; i--) {
            result = result * i;
        }
        return result;
    }

    private static int recursiveFactorial(int value) {
        if (value == 0)
            return 1;
        return value * recursiveFactorial(value - 1);
    }


    private static boolean isPalindrome(String value) {
        if (value.length() <= 1)
            return true;
        if (!firstChar(value).equalsIgnoreCase(lastChar(value)))
            return false;
        return isPalindrome(remainingString(value));

    }

    private static String firstChar(String value) {
        return value.substring(0, 1);
    }

    private static String lastChar(String value) {
        return value.substring(value.length() - 1, value.length());
    }

    private static String remainingString(String value) {

        return value.substring(1, value.length() - 1);
    }


    private static int powerOfNumber(int num, int power) {
        if (power == 0)
            return 1;

        if (power < 0)
            return 1 / powerOfNumber(num, -power);

        if (isEven(power)) {
            int half = powerOfNumber(num, power / 2);
            return half * half;
        }
        if (isOdd(power)) {
            return num * powerOfNumber(num, power - 1);
        }
        return Integer.parseInt("000");
    }


    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    private static boolean isOdd(int num) {
        return !isEven(num);
    }

    //-----------Recursion Related Implementation -----------


    //-----------Merge Sort Implementation -----------

    private static void mergeSort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int halfIndex = (int) Math.floor((startIndex + endIndex) / 2);
            mergeSort(array, startIndex, halfIndex);
            mergeSort(array, halfIndex + 1, endIndex);
            mergeLogic(array, startIndex, halfIndex, endIndex);
        }
    }

    private static void mergeLogic(int[] array, int startIndex, int halfIndex, int endIndex) {

        //Create Two SubArray
        int[] lowHalf = new int[halfIndex - startIndex + 1];
        int[] highHalf = new int[endIndex - halfIndex];

        int k = startIndex;
        int i = 0;
        int j = 0;
        for (i = 0; k <= halfIndex; i++, k++) {
            lowHalf[i] = array[k];
        }
        for (j = 0; k <= endIndex; j++, k++) {
            highHalf[j] = array[k];
        }
        k = startIndex;
        i = 0;
        j = 0;

        //Compare lowHalf and highHalf value in particular index
        // and copy smallest in original array
        while (i < lowHalf.length && j < highHalf.length) {

            if (lowHalf[i] < highHalf[j]) {
                array[k] = lowHalf[i];
                i++;
            } else {
                array[k] = highHalf[j];
                j++;
            }
            k++;
        }
        //Add remaining items from either lowHalf or highHalf
        while (i < lowHalf.length) {
            array[k] = lowHalf[i];
            i++;
            k++;
        }
        while (j < highHalf.length) {
            array[k] = highHalf[j];
            j++;
            k++;
        }

    }
    //-----------Merge Sort Implementation -----------

}
