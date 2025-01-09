package com.course.testdrivendesign;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestDrivenDesignApplicationTests {

    @Autowired
    SalaryService salaryService;

    @Test
    void testSalaryService() {
        Assertions.assertNotNull(salaryService);
        Assertions.assertEquals(100, salaryService.calculateSalary(1));
    }

}
