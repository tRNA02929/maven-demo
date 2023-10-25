package com.ksyun.test;

import java.util.*;

public class SubArray {
    static int max = 1;
    static List<Integer> list;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(in.nextInt());
        }
        list = new ArrayList<>(set);
        list.sort(Comparator.comparingInt(o -> o));
        dfs(max, list.get(0), 1);
        System.out.println(max);
    }

    private static void dfs(int ans, int last, int i) {
        for (int j = i; j < list.size(); j++) {
            if (list.get(j) % last == 0 && list.get(j) > last) {
                max = Math.max(max, ans + 1);
                dfs(ans + 1, list.get(j), j + 1);
            }
        }
    }
}
