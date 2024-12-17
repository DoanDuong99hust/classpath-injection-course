package com.course;

import com.course.farm.util.ScanClassesByJar;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
class ScanClassesByJarTest {

    @Test
    void testFindClasses() throws IOException, ClassNotFoundException {
        ScanClassesByJar scanClassesByJar = new ScanClassesByJar();
        System.out.println(scanClassesByJar.findClasses("/Users/shisui/Documents/LearningProject/classpath-injection-course/FarmFramework/src/main/java/com/course/farm/Main.java"));
    }

}