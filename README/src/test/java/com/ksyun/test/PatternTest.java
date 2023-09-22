package com.ksyun.test;

import java.util.Scanner;

public class PatternTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String pattern = in.next();
        System.out.println(isMatch(str, pattern) ? 1 : 0);
    }

    public static boolean isMatch(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        while (strIndex < str.length() && patternIndex < pattern.length()) {
            if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) != '*') {
                if (str.charAt(strIndex) == pattern.charAt(patternIndex) ||
                        pattern.charAt(patternIndex) == '.') {
                    strIndex++;
                    patternIndex++;
                } else
                    return false;
            } else {
                while (strIndex < str.length() &&
                        (str.charAt(strIndex) == pattern.charAt(patternIndex) ||
                                pattern.charAt(patternIndex) == '.')) {
                    strIndex++;
                }
                patternIndex += 2;
            }
        }
        System.out.println(strIndex + " " + patternIndex);
        if (strIndex >= str.length() && patternIndex >= pattern.length()) {
            return true;
        } else if (strIndex >= str.length()) {
            while (patternIndex < pattern.length()) {
                if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*') {
                    patternIndex += 2;
                } else
                    return false;
            }
            return true;

        } else
            return false;
    }
}
