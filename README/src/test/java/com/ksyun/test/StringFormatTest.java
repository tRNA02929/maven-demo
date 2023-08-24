package com.ksyun.test;

import java.util.Optional;

public class StringFormatTest {

    public static void main(String[] args) {
        System.out.println(Optional.ofNullable("1").orElse(f()));
    }

    public static String f() {
        System.out.println("f");
        return "f";
    }
}
