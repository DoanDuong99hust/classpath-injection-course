package com.course.ooad.indexing.strategy;

import com.course.ooad.indexing.entity.BaseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashIndexing<T extends BaseEntity> implements IndexStrategy<Map<Long, T>> {

    private final Map<Long, T> dataMap = new HashMap<>();

    public HashIndexing(List<T> data) {
        data.forEach(item -> dataMap.put(item.getId(), item));
    }

    public HashIndexing() {
    }

    @Override
    public Map<Long, T> getData() {
        return dataMap;
    }
}
