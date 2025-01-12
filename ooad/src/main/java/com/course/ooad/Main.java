package com.course.ooad;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import com.course.ooad.tdd.impl.Dev3Salary;
import com.course.ooad.tdd.SalaryServiceTemplate;

// Implement TDD
public class Main {


    public static void main(String[] args) {
        SalaryServiceTemplate template = new Dev3Salary();
        System.out.println(template.countingSalary());
    }
}