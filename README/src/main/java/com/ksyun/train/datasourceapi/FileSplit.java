package com.ksyun.train.datasourceapi;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class FileSplit implements Serializable {
    private String fileName;
    private long start;
    private long length;
}
