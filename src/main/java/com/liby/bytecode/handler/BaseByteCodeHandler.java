package com.liby.bytecode.handler;

import com.liby.bytecode.type.ClassFile;

import java.nio.ByteBuffer;

public interface BaseByteCodeHandler {

    /**
     * 解释器的排序值
     * @return
     */
    int order();

    /**
     * 读取
     * @param codeBuf
     * @param classFile
     * @throws Exception
     */
    void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception;

}
