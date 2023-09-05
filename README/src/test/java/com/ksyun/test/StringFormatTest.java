package com.ksyun.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class StringFormatTest {
    public static void main(String[] args) {
        log.error("Hello World!");
    }

    @Test
    public void testStringFormat() {
        String str = "Hello %s!";
        String result = String.format(str, "World");
        log.error(result);
    }
}
