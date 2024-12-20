package com.course.concurrency.problem;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= 10; i++) {
            map.put(i,i);
        }

        DataInConsistence dataInConsistence = new DataInConsistence();

        Thread editing1 = new Thread(new RunnerEditing(map));
        editing1.start();

//        Thread editing2 = new Thread(new RunnerEditing(dataInConsistence.getTestMap()));
//        editing2.start();
    }
}
