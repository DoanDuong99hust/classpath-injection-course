package com.course.agl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// task3: find max value of an array
public class Task3 implements AbstractAlgorithmWithArray {

    private final Logger logger = LoggerFactory.getLogger(Task3.class);

    @Override
    public void runTask(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        logger.info("max={}", max);
    }
}
