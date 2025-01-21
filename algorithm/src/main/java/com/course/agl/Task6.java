package com.course.agl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// find max of all sum of all subarray with length k
public class Task6 implements AbstractAlgorithmWithSubArray {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void runTask(int[] array, int subArrayLength) {
        int[] subSumArray = new int[array.length - subArrayLength];
        for (int i = 0; i < array.length - subArrayLength; i++) {
            int subSum = 0;
            for (int j = i; j < i + subArrayLength; j++) {
                subSum += array[j];
            }
            subSumArray[i] = subSum;
        }

        logger.info("subSumArray={}", subSumArray);
        int maxOfAllSum = 0;

        for (int i = 0; i < subSumArray.length; i++) {
            if (subSumArray[i] > maxOfAllSum) {
                maxOfAllSum = subSumArray[i];
            }
        }
        logger.info("maxOfAllSum={}", maxOfAllSum);
    }
}
