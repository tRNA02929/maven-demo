package com.ksyun.test;

import org.junit.Test;

import java.util.Random;

public class ReverseCoinTest {

    private static int lenCon;

    private static boolean[] statusCoin;

    // 循环轮数
    private static int loopCount;

    // 总次数
    private static long totalCount = 0;

    // 成功翻转全部硬币的次数
    private static long successCount = 0;

    public static void main(String[] args) {
        lenCon = 9;
        loopCount = 10;
        statusCoin = new boolean[lenCon];
        reverseCoin(0);
        System.out.println("总次数：" + totalCount);
        System.out.println("成功次数：" + successCount);
    }

    public static void reverseCoin(int loop) {
        if (loop == loopCount) {
            if (isAllReverse()) {
                successCount++;
            }
            totalCount++;
            return;
        }
        for (int i = 0; i < lenCon; i++) {
            // 任意选择1~3个硬币进行翻转
            Random random = new Random();
            int num = random.nextInt(3) + 1;
            int[] index = new int[num];
            for (int j = 0; j < num; j++) {
                index[j] = random.nextInt(lenCon);
            }
            reverseCoin(index);
            reverseCoin(loop + 1);
            reverseCoin(index);
        }
    }

    // 翻转硬币
    public static void reverseCoin(int[] index) {
        for (int i : index) {
            statusCoin[i] = !statusCoin[i];
        }
    }


    // status判断
    public static boolean isAllReverse() {
        for (boolean status : statusCoin) {
            if (!status) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(3);
            System.out.println(num);
        }
    }
}
