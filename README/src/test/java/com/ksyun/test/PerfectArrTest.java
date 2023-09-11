/**
 * 判断两个字符串的“交集”，例如abc和bc的交集是bc，abcd和cda的交集是cd，abcd和bc的交集为空，
 * 需要计算的交集必须是有序的，必须以前一个字符串的最后一位结束，以后一个字符串的第一位开始
 */

package com.ksyun.test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PerfectArrTest {
    static int max = 0;
    static String result = "";
    static List<String> resultList = new ArrayList<>();
    static int n, m;
    static int[] arr;

    static String[] strings;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(Files.newInputStream(new File("test.txt").toPath()));
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        m = sc.nextInt();
        strings = new String[m];
        for (int i = 0; i < m; ++i) {
            strings[i] = sc.next();
        }
        dfs(arr, new boolean[m], "", 0);
        System.out.println(max);
        System.out.println(result);
        check();
    }

    public static void dfs(int[] arr, boolean[] is, String last, int sum) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < m; ++i) {
            if (!is[i]) {
                String now = strings[i];
                if (now.length() <= last.length() && last.contains(now)) {
                    is[i] = true;
                    dfs(arr, is, last, sum + 1);
                    is[i] = false;
                } else if (now.length() > last.length() && now.contains(last)) {
                    is[i] = true;
                    dfs(change(arr, now.replace(last, "")), is, now, sum + 1);
                    is[i] = false;
                } else {
                    for (int j = 0; j <= last.length(); ++j) {
                        if (last.length() - j <= now.length() && last.substring(j).equals(now.substring(0, last.length() - j))) {
                            String temp = now.substring(last.length() - j);
                            is[i] = true;
                            dfs(change(arr, temp), is, last + temp, sum + 1);
                            is[i] = false;
                            break;
                        }
                    }
                }
            }
        }
//        if (sum == m) {
//            System.out.println(last);
//        }
        if (sum > max) {
            max = sum;
            result = last;
        } else if (sum == max && last.length() < result.length()) {
            result = last;
        }
    }

    public static int[] change(int[] arr, String str) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < str.length(); ++i) {
            int index = str.charAt(i) - 'a';
            if (temp[index] < 1)
                return null;
            temp[index] -= 1;
        }
        return temp;
    }

    public static void check() {
        for (int i = 0; i < m; ++i) {
            if (!result.contains(strings[i]))
                System.out.println(strings[i]);
        }
    }

    @Test
    public void test() {
        System.out.println("abc".substring(3));
    }

}
