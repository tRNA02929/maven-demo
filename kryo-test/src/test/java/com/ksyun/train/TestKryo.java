package com.ksyun.train;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.ksyun.train.Entity.KryoBean;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestKryo {
    private static final Kryo kryo = new Kryo();

    @Test
    public void testKryoOut() {
        KryoBean[] beans = new KryoBean[3];
        beans[0] = KryoBean.builder().name("zhangsan").age(18).address("beijing").build();
        beans[1] = KryoBean.builder().name("lisi").age(19).address("shanghai").build();
        beans[2] = KryoBean.builder().name("wangwu").age(20).address("guangzhou").build();
        try (FileOutputStream fos = new FileOutputStream("src\\test\\resources\\Kryo.bin");
             Output output = new Output(fos)) {
            for (KryoBean bean : beans) {
                kryo.writeObject(output, bean);
//            kryo.writeClassAndObject(output, bean);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testKryoIn() {
        KryoBean[] beans = new KryoBean[3];
        try (FileInputStream fis = new FileInputStream("src\\test\\resources\\Kryo.bin");
             Input input = new Input(fis)) {
            for (int i = 0; i < 3; i++) {
                beans[i] = kryo.readObject(input, KryoBean.class);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (KryoBean bean : beans) {
            System.out.println(bean);
        }
    }

    @Test
    public void test2() {
        String str = "hello";
        Output output = new Output(str.getBytes());
        Input input = new Input(str.getBytes());
        System.out.println(new String(str.getBytes()));
        System.out.println(new String(output.getBuffer()));
        System.out.println(new String(input.getBuffer()));
    }
}
