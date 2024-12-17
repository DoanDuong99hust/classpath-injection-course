package com.course.farm;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, ClassNotFoundException {

        FarmApplication.run(Main.class, args);
    }
}