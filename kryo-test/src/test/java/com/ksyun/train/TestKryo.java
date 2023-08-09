package com.ksyun.train;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import lombok.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
class TestKryoBean {
    private String name;
    private int age;
    private String address;
}

public class TestKryo {
    private static final Kryo kryo = new Kryo();

    @Test
    public void testKryoOut() {
        TestKryoBean bean = TestKryoBean.builder().name("zhangsan").age(18).address("beijing").build();
        try (FileOutputStream fos = new FileOutputStream("src\\test\\resources\\Kryo.bin");
             Output output = new Output(fos)) {
            kryo.writeObject(output, bean);
//            kryo.writeClassAndObject(output, bean);
            output.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testKryoIn() {
        try (FileInputStream fis = new FileInputStream("src\\test\\resources\\Kryo.bin");
             Input input = new Input(fis)) {
            TestKryoBean bean = kryo.readObject(input, TestKryoBean.class);
//            TestKryoBean bean = (TestKryoBean) kryo.readClassAndObject(input);
            System.out.println(bean);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
