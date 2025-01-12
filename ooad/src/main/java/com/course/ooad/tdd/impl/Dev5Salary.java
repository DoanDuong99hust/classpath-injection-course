package com.course.ooad.tdd.impl;

import com.course.ooad.tdd.SalaryServiceTemplate;

public class Dev5Salary extends SalaryServiceTemplate {

    @Override
    public double countingBaseSalary() {
        return 100;
    }

    @Override
    protected double performanceBonus() {
        return 100.0;
    }

    @Override
    protected double campaignBonus() {
        return 2;
    }
}
