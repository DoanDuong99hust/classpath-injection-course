package com.course.farm;

import com.course.farm.annotation.ManualInitBeanProcessor;
import com.course.farm.util.ScanClassedByDir;

import java.io.IOException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        List<Object> objects = ManualInitBeanProcessor.createAnnotatedObjects("com.course");
        for (Object object : objects) {
            System.out.println(object.getClass().getName());
        }

//        ScanClassedByDir scanClassedByDir = new ScanClassedByDir();
//        System.out.println(scanClassedByDir.findClassFilesInRoot(""));
    }
}