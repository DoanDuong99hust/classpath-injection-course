package com.course.agl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// task4: find index that second max of an array when you know index of max value
public class Task4 implements AbstractAlgorithmWithArray {

    private final Logger logger = LoggerFactory.getLogger(Task4.class);

    @Override
    public void runTask(int[] array) {
        int max = array[0];
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                maxIndex = i;
            }
        }

        int secondMaxIndex = 0;
        // maxIndex = 0
        //
        /**
         * after i = 1 -> array[secondMaxIndex] = 20, secondMaxIndex = 0
         * after i = 2 -> array[secondMaxIndex] = 20, secondMaxIndex = 0
         * after i = 3 -> array[secondMaxIndex] = 4, secondMaxIndex = 3
         * after i = 4 -> array[secondMaxIndex] = 4, secondMaxIndex = 3
         * after i = 5 -> array[secondMaxIndex] = 6, secondMaxIndex = 5
         * after i = 6 -> array[secondMaxIndex] = 11, secondMaxIndex = 6
         * after i = 7 -> array[secondMaxIndex] = 11, secondMaxIndex = 6
         * after i = 8 -> array[secondMaxIndex] = 11, secondMaxIndex = 6
         * after i = 9 -> array[secondMaxIndex] = 11, secondMaxIndex = 6
         */
        for (int i = 1; i < array.length; i++) { // todo: fix
            if (array[secondMaxIndex] < array[i] && maxIndex != i) {
                secondMaxIndex = i;
            }
        }

        logger.info("maxValue={}, secondMaxIndex={}",
                array[maxIndex], secondMaxIndex);
    }
}
