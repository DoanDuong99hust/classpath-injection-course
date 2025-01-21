package com.course.agl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// task1: print all index and its corresponding value of an array
public class Task1 implements AbstractAlgorithmWithArray {

    private final Logger logger = LoggerFactory.getLogger(Task1.class);
    @Override
    public void runTask(int[] array) {
        for(int i=0; i<array.length; i++){
            logger.info("index={};value={}",i, array[i]);
        }
    }
}
