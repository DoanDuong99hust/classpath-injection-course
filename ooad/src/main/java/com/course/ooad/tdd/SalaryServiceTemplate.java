package com.course.ooad.tdd;

public abstract class SalaryServiceTemplate {
    public double countingSalary() {
        return countingBaseSalary() + countingSalaryForInsurance()
                + performanceBonus() + campaignBonus();
    }
    protected double countingSalaryForInsurance() {
        return 5;
    }
    protected double countingBaseSalary(){
        return 10;
    }
    protected abstract double performanceBonus();
    protected abstract double campaignBonus();
}
