package com.course.ooad.indexing.entity;

public class People extends BaseEntity {

    private String name;
    private Integer age;

    public People(Long id, String name, Integer age) {
        super(id);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
}
