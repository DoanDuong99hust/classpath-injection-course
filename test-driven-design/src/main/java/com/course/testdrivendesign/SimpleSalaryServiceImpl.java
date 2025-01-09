package com.course.testdrivendesign;

import org.springframework.stereotype.Service;

@Service
public class SimpleSalaryServiceImpl implements SalaryService {

    @Override
    public double calculateSalary(Integer ratio) {
        return 100 * ratio;
    }
}
