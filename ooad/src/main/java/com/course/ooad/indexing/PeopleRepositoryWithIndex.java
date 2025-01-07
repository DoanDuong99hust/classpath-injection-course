package com.course.ooad.indexing;

import java.util.List;
import java.util.Map;

public class PeopleRepositoryWithIndex implements PeopleRepository {

    private Map<String, People> peopleMap;

    public PeopleRepositoryWithIndex(List<People> people) {
        for (People p : people) {
            peopleMap.put(p.getName(), p);
        }
    }

    @Override
    public People getPeopleByName(String name) {
        return peopleMap.get(name);
    }
}
