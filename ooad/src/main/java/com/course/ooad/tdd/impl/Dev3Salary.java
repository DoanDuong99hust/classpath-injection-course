package com.course.ooad.tdd.impl;

import com.course.ooad.tdd.SalaryServiceTemplate;

public class Dev3Salary extends SalaryServiceTemplate {

    @Override
    public double countingBaseSalary() {
        return 10;
    }

    @Override
    protected double performanceBonus() {
        return 1;
    }

    @Override
    protected double campaignBonus() {
        return 1;
    }
}
