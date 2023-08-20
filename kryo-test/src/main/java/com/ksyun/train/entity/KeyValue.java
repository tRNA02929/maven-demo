package com.ksyun.train.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KeyValue<K, V> implements java.io.Serializable {
    K key;
    V value;
}
