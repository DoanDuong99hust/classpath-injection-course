package com.course.customer;

import com.course.farm.FarmApplication;
import com.course.farm.annotation.FarmCoreApplication;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@FarmCoreApplication(enableHttp = true)
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        FarmApplication.run(Main.class, args);
    }
}