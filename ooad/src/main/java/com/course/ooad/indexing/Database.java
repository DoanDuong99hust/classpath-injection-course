package com.course.ooad.indexing;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private  indexStrategy;
    private

    private static List<People> people = List.of(
            new People("Duong", 25),
            new People("Tung", 25),
            new People("Tu", 24),
            new People("Hoang", 26)
    );

    public static List<People> getPeople() {
        return people;
    }


}
