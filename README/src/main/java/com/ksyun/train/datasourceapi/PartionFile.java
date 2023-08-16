package com.ksyun.train.datasourceapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class PartionFile implements Serializable {
    private int partionId;
    private FileSplit[] fileSplits;
}
