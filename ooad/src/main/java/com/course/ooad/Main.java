package com.course.ooad;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import com.course.ooad.indexing.DatabaseEngine;
import com.course.ooad.indexing.PeopleRepositoryImpl;
import com.course.ooad.indexing.Repository;
import com.course.ooad.indexing.strategy.NoIndexing;

// Implement TDD
public class Main {


    public static void main(String[] args) {
        DatabaseEngine engine = new DatabaseEngine();
        engine.setStrategy(new NoIndexing());
        Repository repository = new PeopleRepositoryImpl(engine);
        long startTime = System.nanoTime();
        System.out.println(repository.findByID("name 9999"));
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}