package com.ksyun.train;

import lombok.Data;

import java.util.Collection;
import java.util.Optional;
import java.util.SortdSet;
import java.util.TreeSet;

@Data
class People{
    private String name;
    private int age;

}

public class Main {
    public static void main(String[] args) throws Exception {
        Optional<String> optional = Optional.of("bam");
        TreeSet<String> set = new TreeSet<>();
        set.add("a");
        set.add("d");
        set.add("c");
        System.out.println(set.pollFirst());
        System.out.println(set.first());

        for (String s : set) {
            System.out.println(s);
        }
    }
    public static boolean isEmpty(Collection coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isNotEmpty(Collection coll) {
        return !isEmpty(coll);
    }


}