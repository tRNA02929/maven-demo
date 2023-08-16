package com.ksyun.train.datasourceapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class UnsplitFileFormat implements FileFormat {

    @Override
    public boolean isSplitable(String filePath) {
        return false;
    }


    @Override
    public PartionFile[] getSplits(String filePath, long size) {
        List<PartionFile> partiongFileList = new ArrayList<>();
        //todo 学生实现 driver端切分split的逻辑
        File file = new File(filePath);
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                //todo
                ;
            }
        }
        return partiongFileList.toArray(new PartionFile[partiongFileList.size()]);
    }

    @Override
    public PartionReader createReader() {
        return new TextPartionReader();
    }

    @Override
    public PartionWriter createWriter(String destPath, int partionId) {
        return new TextPartionWriter(destPath, partionId);
    }


}
