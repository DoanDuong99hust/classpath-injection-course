package com.course.springcustomer;

import com.course.testdrivendesign.SalaryService;
import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Override
    public double calculateSalary(Integer ratio) {
        return 100 * ratio;
    }
}
