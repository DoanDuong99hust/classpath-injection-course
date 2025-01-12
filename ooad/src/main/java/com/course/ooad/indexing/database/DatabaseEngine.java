package com.course.ooad.indexing.database;

import com.course.ooad.indexing.strategy.BTreeIndexing;
import com.course.ooad.indexing.strategy.HashIndexing;
import com.course.ooad.indexing.strategy.IndexStrategy;
import com.course.ooad.indexing.strategy.NoIndexing;

import java.util.*;

public abstract class DatabaseEngine<T> {

    protected Map<Class<?>, IndexStrategy<?>> strategyMap;
    protected IndexStrategy<?> strategy;

    DatabaseEngine(List<T> data) {
        strategyMap = new HashMap<>();
        strategyMap.put(NoIndexing.class, new NoIndexing(data));
        strategyMap.put(BTreeIndexing.class, new BTreeIndexing(data));
        strategyMap.put(HashIndexing.class, new HashIndexing(data));
    }
}
