package com.ksyun.train.datasourceapi;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KeyValue<K, V> implements java.io.Serializable {
    K key;
    V value;
}
