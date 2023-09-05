package com.ksyun.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.ZoneId;
import java.util.Optional;

@Slf4j
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


    @Test
    public void testStringFormat() {
        String str = "Hello %s!";
        String result = String.format(str, "World");
        log.error(result);
    }
}
