package com.course.ooad;

import com.course.ooad.indexing.Database;
import com.course.ooad.indexing.People;
import com.course.ooad.indexing.PeopleRepository;
import com.course.ooad.indexing.PeopleRepositoryWithIndex;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        PeopleRepository repository1 = new PeopleRepositoryWithIndex(Database.getPeople());
        People peopleWithIndex =  repository1.getPeopleByName("Hoang");
        System.out.println(peopleWithIndex);
    }
}