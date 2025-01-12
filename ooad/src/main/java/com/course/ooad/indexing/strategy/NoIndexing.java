package com.course.ooad.indexing.strategy;

import com.course.ooad.indexing.People;

import java.util.List;

public class NoIndexing implements IndexStrategy<List<People>>{

    private List<People> people;

    public NoIndexing(List<People> people) {
        this.people = people;
    }

    public NoIndexing() {
    }

    @Override
    public List<People> getData() {
        return this.people;
    }
}
