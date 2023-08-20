package com.ksyun.train;

import com.ksyun.train.schema.TopN;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;

public class KryoOut {
    public static void main(String[] args) {
        TopN topN = TopN.newBuilder()
                .setKey("key")
                .setValue(1)
                .build();

        DatumWriter<TopN> datumWriter = new SpecificDatumWriter<>(TopN.class);
        try (DataFileWriter<TopN> dataFileWriter = new DataFileWriter<>(datumWriter)) {
            dataFileWriter.create(topN.getSchema(), new File("topN.avro"));
            dataFileWriter.append(topN);
            dataFileWriter.append(topN);
            dataFileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
