package com.ksyun.train.Entity;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public
class KryoBean {
    private String name;
    private int age;
    private String address;
}
