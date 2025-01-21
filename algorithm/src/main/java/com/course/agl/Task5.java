package com.course.agl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// task5: find all sum of all subarray with length k
public class Task5 implements AbstractAlgorithmWithSubArray {

    private final Logger logger = LoggerFactory.getLogger(Task5.class);

    @Override
    public void runTask(int[] array, int subArrayLength) {
        int finalSum = 0;
        for (int i = 0; i < array.length - subArrayLength; i++) {
            int subSum = 0;
            for (int j = i; j < i + subArrayLength; j++) {
                subSum += array[j];
            }
            finalSum += subSum;
        }

        logger.info("finalSum:{}", finalSum);
    }
}
