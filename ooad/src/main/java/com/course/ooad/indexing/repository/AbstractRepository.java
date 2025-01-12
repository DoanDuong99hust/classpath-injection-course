package com.course.ooad.indexing.repository;

import com.course.ooad.indexing.database.AbstractTable;
import com.course.ooad.indexing.entity.BaseEntity;
import com.course.ooad.indexing.strategy.BTreeIndexing;
import com.course.ooad.indexing.strategy.HashIndexing;
import com.course.ooad.indexing.strategy.NoIndexing;

import java.util.List;
import java.util.Map;

public abstract class AbstractRepository<T extends BaseEntity> {
    private final AbstractTable<T> abstractTable;

    protected AbstractRepository(AbstractTable<T> abstractTable) {
        this.abstractTable = abstractTable;
    }


    protected T baseFindById(Long id) {
        if (abstractTable.getStrategy() instanceof NoIndexing) {
            List<T> data = abstractTable.getData();
            for (T item : data) {
                if (item.getId().equals(id)) {
                    return item;
                }
            }
        }

        if (abstractTable.getStrategy() instanceof HashIndexing || abstractTable.getStrategy() instanceof BTreeIndexing) {
            Map<Long, T> people = abstractTable.getData();
            return people.get(id);
        }

        return null;
    }
}
