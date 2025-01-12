package com.course.ooad.indexing.repository;


import com.course.ooad.indexing.database.PeopleTable;
import com.course.ooad.indexing.entity.People;

public class PeopleRepositoryImpl extends AbstractRepository<People> {

    public PeopleRepositoryImpl(PeopleTable peopleTable) {
        super(peopleTable);
    }

    public People findByID(Long id) {
        return baseFindById(id);
    }
}
