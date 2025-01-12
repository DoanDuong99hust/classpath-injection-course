package com.course.ooad.indexing;

public interface Repository<T, X> {

    T findByID(X id);
}
