package com.ksyun.train.avro;

import com.ksc.serde.SerdeConst;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;

public class AvroDemo3 {
    public static void main(String[] args) throws IOException {
        // 创建学生对象
        Student student = new Student(105,"TEST_STUDENT");

        // 创建文件
        File file = new File(SerdeConst.BASE_PATH+"student3.avro");
        // 创建一个DatumWriter，并用它来构建一个DataFileWriter
        DatumWriter<Student> studentDatumWriter = new SpecificDatumWriter<>(Student.class);
        DataFileWriter<Student> dataFileWriter = new DataFileWriter<>(studentDatumWriter);
        dataFileWriter.create(student.getSchema(), file);
        for(int i=0;i<SerdeConst.LENGTH;i++)
            dataFileWriter.append(student);
        dataFileWriter.close();

        // 创建一个DatumReader，并用它来构建一个DataFileReader
        DatumReader<Student> studentDatumReader = new SpecificDatumReader<>(Student.class);
        DataFileReader<Student> dataFileReader = new DataFileReader<>(file, studentDatumReader);
        Student student1 = null;
        while (dataFileReader.hasNext()) {
            student1 = dataFileReader.next(student1);
        }
        System.out.println(student1);
    }
}
