package com.ksyun.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LombokTest {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    @Test
    public void testSlf4j() {
        System.out.println("Hello World!");
    }
}
