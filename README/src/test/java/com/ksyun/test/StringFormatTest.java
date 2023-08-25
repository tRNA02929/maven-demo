package com.ksyun.test;

import org.junit.Test;

import java.time.ZoneId;
import java.util.Optional;

public class StringFormatTest {

    public static void main(String[] args) {
        System.out.println(Optional.ofNullable("1").orElse(f()));
    }

    public static String f() {
        System.out.println("f");
        return "f";
    }

    @Test
    public void testZone() {
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        System.out.println(zoneId);
    }
}
