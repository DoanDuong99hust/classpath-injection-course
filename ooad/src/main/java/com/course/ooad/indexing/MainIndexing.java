package com.course.ooad.indexing;

import com.course.ooad.indexing.repository.PeopleRepositoryImpl;
import com.course.ooad.indexing.database.PeopleTable;
import com.course.ooad.indexing.strategy.HashIndexing;
import com.course.ooad.indexing.strategy.NoIndexing;

// Implement a simple database providing index
public class MainIndexing {

    public static void main(String[] args) {
        PeopleTable table = new PeopleTable(new NoIndexing<>());
        PeopleRepositoryImpl repository = new PeopleRepositoryImpl(table);
        long startTime = System.nanoTime();
        System.out.println(repository.findByID(900000L));
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}
