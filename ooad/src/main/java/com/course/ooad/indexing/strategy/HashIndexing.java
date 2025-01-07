package com.course.ooad.indexing.strategy;

import com.course.ooad.indexing.People;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashIndexing implements IndexStrategy<Map<String, People>> {

    Map<String, People> peopleMap = new HashMap<>();

    public HashIndexing(List<People> data) {
        for (People p : data) {
            peopleMap.put(p.getName(), p);
        }
    }

    @Override
    public Map<String, People> getData() {
        return peopleMap;
    }
}
