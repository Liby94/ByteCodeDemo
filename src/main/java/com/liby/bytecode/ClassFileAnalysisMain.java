package com.liby.bytecode;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ClassFileAnalysisMain {

    public static ByteBuffer readFile(String classFilePath) throws Exception {
        File file = new File(classFilePath);
        if (!file.exists()) {
            throw new Exception(file.getPath() + " file not exist!");
        }
        System.out.println("read file path: " + file.getAbsolutePath());
        byte[] byteCodeBuf = new byte[4096];
        int length;
        try (InputStream inputStream = new FileInputStream(file)) {
            length = inputStream.read(byteCodeBuf);
        }
        if (length < 1) {
            throw new Exception("not read byte code.");
        }
        return ByteBuffer.wrap(byteCodeBuf, 0, length).asReadOnlyBuffer();
    }



}
