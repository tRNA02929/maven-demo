package com.ksyun.train;

import com.ksyun.train.schema.TopN;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;

import java.io.File;

public class KryoIn {
    public static void main(String[] args) {
        DatumReader<TopN> datumReader = new SpecificDatumReader<>(TopN.class);
        try (DataFileReader<TopN> dataFileReader = new DataFileReader<>(new File("topN.avro"), datumReader)) {
            TopN topN = null;
            while (dataFileReader.hasNext()) {
                topN = dataFileReader.next(topN);
                System.out.println(topN.getKey());
                System.out.println(topN.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
