package com.ksyun.train.avro;

import com.ksc.serde.SerdeConst;
import com.ksc.serde.Student;
import org.apache.avro.Schema;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumReader;
import org.apache.avro.reflect.ReflectDatumWriter;

import java.io.File;
import java.io.IOException;

public class AvroDemo1 {
    public static void main(String[] args) throws IOException {
        Student student = new Student(104, "TEST_STUDENT");
        // 根据 Student 类创建 Schema
        Schema schema = ReflectData.get().getSchema(Student.class);

        File file = new File(SerdeConst.BASE_PATH +"student1.avro");
        DatumWriter<Student> studentDatumWriter = new ReflectDatumWriter<>(Student.class);
        DataFileWriter<Student> studentDataFileWriter = new DataFileWriter<>(studentDatumWriter);
        studentDataFileWriter.create(schema, file);
        for (int i = 0; i < 100000; i++)
            studentDataFileWriter.append(student);
        studentDataFileWriter.close();

        File file2 = new File(SerdeConst.BASE_PATH + "student1_codec.avro");
        DatumWriter<Student> studentDatumWriter2 = new ReflectDatumWriter<>(Student.class);
        DataFileWriter<Student> studentDataFileWriter2 = new DataFileWriter<>(studentDatumWriter2);
        //设置压缩方式为Deflate
        studentDataFileWriter2.setCodec(CodecFactory.deflateCodec(CodecFactory.DEFAULT_DEFLATE_LEVEL));
        //studentDataFileWriter2.setCodec(CodecFactory.snappyCodec()); //snappy压缩,需要引入snappy依赖包
        studentDataFileWriter2.create(schema, file2);
        for (int i = 0; i < 100000; i++)
            studentDataFileWriter2.append(student);
        studentDataFileWriter2.close();


        // 从磁盘反序列化 Students
        DatumReader<Student> studentDatumReader = new ReflectDatumReader<>(Student.class);
        DataFileReader<Student> studentDataFileReader = new DataFileReader<>(file, studentDatumReader);
        Student deStudent = null;
        while (studentDataFileReader.hasNext()) {
            deStudent = studentDataFileReader.next();
        }
        System.out.println(deStudent);
    }
}
