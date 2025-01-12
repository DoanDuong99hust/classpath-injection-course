package com.course.ooad.indexing.strategy;

import com.course.ooad.indexing.People;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BTreeIndexing implements IndexStrategy<Map<String, People>> {

    private Map<String, People> mapData = new TreeMap<>();

    public BTreeIndexing(List<People> peopleList) {
        for (People people : peopleList) {
            mapData.put(people.toString(), people);
        }
    }

    public BTreeIndexing() {
    }

    @Override
    public Map<String, People> getData() {
        return mapData;
    }
}
