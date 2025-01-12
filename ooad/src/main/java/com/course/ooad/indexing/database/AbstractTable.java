package com.course.ooad.indexing.database;

import com.course.ooad.indexing.strategy.IndexStrategy;

import java.util.List;

public abstract class AbstractTable<T> extends DatabaseEngine<T>{

    AbstractTable(List<T> data) {
        super(data);
    }

    public IndexStrategy<?> getStrategy() {
        return strategy;
    }

    public <X> X getData(){
        return (X) strategyMap.get(strategy.getClass()).getData();
    }
}
