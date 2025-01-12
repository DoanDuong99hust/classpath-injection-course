package com.course.ooad.indexing.database;

import com.course.ooad.indexing.entity.People;
import com.course.ooad.indexing.strategy.IndexStrategy;
import com.course.ooad.indexing.util.CommonUtil;

import java.util.List;

public class PeopleTable extends AbstractTable<People> {

    public PeopleTable(IndexStrategy<?> strategy) {
        super(CommonUtil.generatePeople());
        this.strategy = strategy;
    }

    public List<People> getPeople() {
        return getData();
    }
}
