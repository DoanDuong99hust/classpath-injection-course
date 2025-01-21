package com.course.agl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// task2: find sum of all even-index element
public class Task2 implements AbstractAlgorithmWithArray {

    private final Logger logger = LoggerFactory.getLogger(Task2.class);
    @Override
    public void runTask(int[] array) {
        int evenSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                evenSum += array[i];
            }
        }

        logger.info("evenSum={}", evenSum);
    }
}
