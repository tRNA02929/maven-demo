package com.ksyun.train.datasourceapi;

import java.io.IOException;
import java.io.Serializable;
import java.util.stream.Stream;

public class TextPartionReader implements PartionReader<String>, Serializable {


    @Override
    public Stream<String> toStream(PartionFile partionFile) throws IOException {
        Stream<String> allStream = Stream.empty();
        //todo 学生实现 maptask读取原始数据文件的内容

        return allStream;
    }
}
