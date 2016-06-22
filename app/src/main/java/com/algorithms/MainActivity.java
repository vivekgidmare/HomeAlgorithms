package com.algorithms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    private int[] array = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    private int[] selectionSortArray = {61, 67, 71, 73, 2, 3, 53, 59, 79, 83, 89, 97, 5, 7, 11, 13, 37, 41, 43, 47, 17, 19, 23, 29, 31};
    private int[] insertionArray = {22, 11, 99, 88, 9, 7, 42};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Size :" + array.length);

        //Binary Search Testing
        int result = binarySearch(67);
        Log.i(TAG, "Search Result ::" + result);
        int result2 = binarySearch(62);
        Log.i(TAG, "Search result2 ::" + result2);

        //Selection sort testing
        Log.i(TAG, "Before selection sort\n:" + Arrays.toString(selectionSortArray));
        selectionSort(selectionSortArray);
        Log.i(TAG, "After selection sort\n:" + Arrays.toString(selectionSortArray));

        //Insertion sort testing
        Log.i(TAG, "Before insertion sort\n:" + Arrays.toString(insertionArray));
        insertionSort(insertionArray);
        Log.i(TAG, "After insertion sort\n:" + Arrays.toString(insertionArray));


    }

    private int binarySearch(int input) {
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
            Log.i(TAG, "*" + guess);
        }
        return -1;
    }

    //-------------Selection Sort---------------

    private void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private int indexOfMinimum(int[] array, int startIndex) {
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

    private void selectionSort(int[] array) {
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            minIndex = indexOfMinimum(array, i);
            swap(array, minIndex, i);
        }

    }
    //-------------Selection Sort---------------

    //-------------Insertion Sort---------------
    private void insert(int[] array, int rightIndex, int value) {
        int index = 0;
        for (index = rightIndex; index >= 0 && value < array[index]; index--) {
            array[index + 1] = array[index];
        }
        array[index + 1] = value;
    }

    private void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            insert(array, i - 1, array[i]);
        }
    }
    //-------------Insertion Sort---------------
}
