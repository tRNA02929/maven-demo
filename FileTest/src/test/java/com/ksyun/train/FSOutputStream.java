package com.ksyun.train;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

public class FSOutputStream extends OutputStream {

    Vector<Byte> bytes = new Vector<>();

    @Override
    public void write(int b) throws IOException {
        bytes.add((byte) b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        for (byte b1 : b) {
            bytes.add(b1);
        }
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++) {
            bytes.add(b[i]);
        }
    }

    @Override
    public void close() throws IOException {
        super.close();
        System.out.println(bytes);
    }

    @Override
    public void flush() throws IOException {
        super.flush();
        System.out.println(bytes);
    }
}
