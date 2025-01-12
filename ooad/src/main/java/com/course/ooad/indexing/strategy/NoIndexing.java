package com.course.ooad.indexing.strategy;

import com.course.ooad.indexing.entity.BaseEntity;

import java.util.List;

public class NoIndexing<T extends BaseEntity> implements IndexStrategy<List<T>>{

    private List<T> data;

    public NoIndexing(List<T> data) {
        this.data = data;
    }

    public NoIndexing() {
    }

    @Override
    public List<T> getData() {
        return this.data;
    }
}
