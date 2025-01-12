package com.course.ooad.indexing;

import com.course.ooad.indexing.strategy.BTreeIndexing;
import com.course.ooad.indexing.strategy.HashIndexing;
import com.course.ooad.indexing.strategy.IndexStrategy;
import com.course.ooad.indexing.strategy.NoIndexing;

import java.util.*;

public class DatabaseEngine {

    private IndexStrategy<?> strategy;
    private Map<Class<?>, IndexStrategy<?>> strategyMap;

    public DatabaseEngine() {
        List<People> people = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            people.add(new People("name " + i, i));
        }

        strategyMap = new HashMap<>();
        strategyMap.put(NoIndexing.class, new NoIndexing(people));
        strategyMap.put(BTreeIndexing.class, new BTreeIndexing(people));
        strategyMap.put(HashIndexing.class, new HashIndexing(people));
    }

    public void setStrategy(IndexStrategy<?> strategy) {
        this.strategy = strategy;
    }

    public <T> T getPeople() {
        return (T) strategyMap.get(strategy.getClass()).getData();
    }

    public IndexStrategy<?> getStrategy() {
        return strategy;
    }

}
