package com.course.ooad.indexing;


import com.course.ooad.indexing.strategy.BTreeIndexing;
import com.course.ooad.indexing.strategy.HashIndexing;
import com.course.ooad.indexing.strategy.NoIndexing;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PeopleRepositoryImpl implements Repository<People, String> {

    private DatabaseEngine databaseEngine;

    public PeopleRepositoryImpl(DatabaseEngine databaseEngine) {
        this.databaseEngine = databaseEngine;
    }


    @Override
    public People findByID(String id) {
        People person = null;
        if (databaseEngine.getStrategy() instanceof NoIndexing) {
            List<People> people = databaseEngine.getPeople();
            for (People p : people) {
                if (id.equals(p.getName()))
                    person = p;
            }
        }

        if (databaseEngine.getStrategy() instanceof HashIndexing || databaseEngine.getStrategy() instanceof BTreeIndexing) {
            Map<String, People> peopleMap = databaseEngine.getPeople();
            person = peopleMap.get(id);
        }
        return person;
    }
}
