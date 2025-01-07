package com.course.ooad.indexing;

import java.util.List;

public class PeopleRepositoryWithoutIndex implements PeopleRepository {

    private List<People> people;

    public PeopleRepositoryWithoutIndex(List<People> people) {
        this.people = people;
    }

    @Override
    public People getPeopleByName(String name) {
        for (People p : people) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
}
