package com.ksyun.test;

import java.util.Arrays;
import java.util.Scanner;

public class HeroFight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int coin = 0, max = 0;
        for (int i = 0; i < n; i++) {
            if (a >= arr[i]) {
                coin++;
                max = Math.max(max, coin);
            } else if (a + coin >= arr[i]) {
                coin -= arr[i] - a - 1;
                a = arr[i];
            } else {
                break;
            }
        }
        System.out.println(max);
    }
}
