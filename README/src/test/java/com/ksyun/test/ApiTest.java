package com.ksyun.test;

import com.ksyun.train.datasourceapi.*;
import org.junit.Test;

import java.io.File;

public class ApiTest {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    @Test
    public void testFileFormat() {
        FileFormat fileFormat = new UnsplitFileFormat();
        File file = new File("data");
        System.out.println(file.getAbsolutePath());
        PartionFile[] partionFiles = fileFormat.getSplits(file.getAbsolutePath(), 1000);
    }
}
