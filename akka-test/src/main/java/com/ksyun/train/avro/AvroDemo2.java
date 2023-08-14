package com.ksyun.train.avro;

import com.ksc.serde.SerdeConst;
import com.ksc.serde.Student;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.reflect.ReflectDatumReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class AvroDemo2 {
    public static void main(String[] args) throws IOException {
        // 加载模式
        InputStream stream2 = AvroDemo2.class.getClassLoader().getResourceAsStream("student.avsc");
        Schema schema = new Schema.Parser().parse(stream2);

        // 创建一些用户
        GenericData.Record user1 = new GenericData.Record(schema);
        user1.put("name", "TEST_STUDENT");
        user1.put("no", 106);

        // 将用户序列化到磁盘
        File file = new File(SerdeConst.BASE_PATH +"student2.avro");
        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<>(schema);
        DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<>(datumWriter);
        dataFileWriter.create(schema, file);
        for (int i = 0; i < SerdeConst.LENGTH; i++)
            dataFileWriter.append(user1);
        dataFileWriter.close();

        // 现在，让我们从磁盘中读取并反序列化我们的用户
        DatumReader<GenericRecord> datumReader = new GenericDatumReader<>(schema);
        DataFileReader<GenericRecord> dataFileReader = new DataFileReader<>(file, datumReader);
        GenericRecord user = null;
        while (dataFileReader.hasNext()) {
            user = dataFileReader.next(user);
        }
        System.out.println(user.get("name").toString());
        System.out.println(user.get("no").toString());

        // 从磁盘反序列化 Students
        DatumReader<Student> studentDatumReader = new ReflectDatumReader<>(Student.class);
        DataFileReader<Student> studentDataFileReader = new DataFileReader<>(file, studentDatumReader);
        Student student = null;
        while (studentDataFileReader.hasNext()) {
            student = studentDataFileReader.next(student);
        }
        System.out.println(student);
    }
}
