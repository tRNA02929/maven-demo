package com.ksyun.train;

import lombok.*;

import java.util.concurrent.ConcurrentSkipListSet;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = "age")
@Builder
class People implements Comparable<People> {
    private String name;
    private int age;
    private String sex;

    @Override
    public int compareTo(People o) {
        if (equals(o))
            return 0;
        return age - o.age;
    }
}


public class TestThread {
    public static void main(String[] args) {
        ConcurrentSkipListSet<People> set = new ConcurrentSkipListSet<>();
        set.add(People.builder().age(18).name("t1").sex("1").build());
        set.add(People.builder().age(19).name("t2   ").sex("1").build());
        set.add(People.builder().age(18).name("t1").sex("1").build());

        System.out.println(set);
    }
}
