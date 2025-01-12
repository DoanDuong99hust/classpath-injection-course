package com.course.ooad.indexing.entity;

// stand for @Entity
public class BaseEntity {
    private Long id;

    public BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
