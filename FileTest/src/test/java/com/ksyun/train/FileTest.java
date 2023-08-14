package com.ksyun.train;

import com.google.common.collect.Lists;
import com.google.common.io.Files;
import lombok.*;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;


@Getter
@Setter
@ToString
@With
@NoArgsConstructor
@AllArgsConstructor
class People {
    private String name = "hello";

    private Student student = new Student();

    @Getter
    @ToString
    class Student {
        private String name = "hello";
    }
}

public class FileTest {

    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        System.out.println(file.getAbsolutePath());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write("hello".getBytes());
    }

    @Test
    public void testFile() throws IOException {
        File file = new File("test.txt");
        System.out.println(file.getAbsolutePath());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write("你好".getBytes());
        fileOutputStream.write("hello1".getBytes());
//        fileOutputStream.flush();

    }

    @Test
    public void testFile2() throws IOException {
        File file = new File("test.txt");
        System.out.println(file.getAbsolutePath());
        FileUtils.writeStringToFile(file, "hello", "utf-8");
        FileUtils.writeStringToFile(file, "hello1", "utf-8", true);
        FileUtils.writeByteArrayToFile(file, "hello2".getBytes(), true);
        System.out.println(new String(Files.asByteSource(file).read()));
    }

    @Test
    public void test() throws UnsupportedEncodingException {
        byte[] bytes = "你好world".getBytes();
        System.out.println(new String("你好world".getBytes()));
        System.out.println(URLEncoder.encode("你好world", "utf-8"));
    }
}
