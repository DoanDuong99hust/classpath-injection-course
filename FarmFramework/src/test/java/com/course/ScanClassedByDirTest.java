package com.course;

import com.course.farm.util.ScanClassedByDir;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ScanClassedByDirTest {

    @Test
    void testFindClasses() throws ClassNotFoundException, IOException {
        ScanClassedByDir scanClassedByDir = new ScanClassedByDir();
        System.out.println(scanClassedByDir.findClassFilesInRoot(""));
    }
}