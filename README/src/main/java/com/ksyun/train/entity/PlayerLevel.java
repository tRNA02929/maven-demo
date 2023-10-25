package com.ksyun.train.entity;

import com.ksyun.train.datasourceapi.KeyValue;

import java.util.List;

public class PlayerLevel {
    private class Level {
        public int level;
        public List curve;
    }

    public List<Level> levels;
}
