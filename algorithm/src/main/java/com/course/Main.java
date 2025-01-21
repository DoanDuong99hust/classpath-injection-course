package com.course;

import com.course.agl.*;
import org.apache.log4j.BasicConfigurator;

/**
 * task1: print all index and its corresponding value of an array
 * task2: find sum of all even-index element
 * task3: find max value of an array
 * task4: find index that second max of an array when you know index of max value
 * task5: find all sum of all subarray with length k (A subarray is a contiguous non-empty sequence of elements within an array.)
 * task6: find max of all sum of all subarray with length k (A subarray is a contiguous non-empty sequence of elements within an array.)
 * task7: find a hashCode of an integer in context this integer will be put to an array size 10, 20, ...
 * task8: iteration a linked list
 * task9: reversed linked list (iteration)
 */

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        //                    0, 1, 2, 3, 4 , 5, 6 , 7, 8, 9
        int[] arr = new int[]{20, 2, 3, 4, 15, 6, 11, 8, 9, 10};
        AbstractAlgorithmWithArray array = new Task4();
        array.runTask(arr);
    }
}