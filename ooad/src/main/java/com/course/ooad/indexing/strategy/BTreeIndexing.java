package com.course.ooad.indexing.strategy;

import com.course.ooad.indexing.entity.BaseEntity;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BTreeIndexing<T extends BaseEntity> implements IndexStrategy<Map<Long, T>> {

    private final Map<Long, T> mapData = new TreeMap<>();

    public BTreeIndexing(List<T> data) {
        data.forEach(item -> mapData.put(item.getId(), item));
    }

    public BTreeIndexing() {
    }

    @Override
    public Map<Long, T> getData() {
        return mapData;
    }
}
