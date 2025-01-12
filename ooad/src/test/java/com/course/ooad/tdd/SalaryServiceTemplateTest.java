package com.course.ooad.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

class SalaryServiceTemplateTest {

    @Test
    void testSalaryImpl() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Reflections reflections = new Reflections("com.course.ooad.tdd.outsource");
        Set<Class<? extends SalaryServiceTemplate>> implSet = reflections.getSubTypesOf(SalaryServiceTemplate.class);
        for (Class<? extends SalaryServiceTemplate> clazz : implSet) {
            SalaryServiceTemplate impl = clazz.getDeclaredConstructor().newInstance();
            Assertions.assertNotNull(impl);
            Assertions.assertEquals(100, impl.countingSalary());
        }
    }

}