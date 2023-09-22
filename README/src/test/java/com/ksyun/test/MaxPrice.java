package com.ksyun.test;

import java.util.Scanner;
import java.util.stream.Stream;

public class MaxPrice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] price = Stream.of(in.next().split(",")).mapToInt(Integer::parseInt).toArray();
        int n = price.length;
        int max = 0;
        int minP = price[0];
        for (int i = 1; i < n; i++) {
            if (price[i] > minP) {
                max = Math.max(max, price[i] - minP);
            } else {
                minP = price[i];
            }
        }
        System.out.println(max);
    }
}
