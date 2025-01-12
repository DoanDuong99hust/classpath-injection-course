package com.course.ooad.indexing.util;

import com.course.ooad.indexing.entity.People;

import java.util.ArrayList;
import java.util.List;

public class CommonUtil {

    public static List<People> generatePeople() {
        List<People> people = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            people.add(new People((long)i,"name " + i, i));
        }
        return people;
    }

    private CommonUtil() {
    }
}
