package com.liby.bytecode.handler;

import com.liby.bytecode.type.ClassFile;
import com.liby.bytecode.type.U4;

import java.nio.ByteBuffer;

public class MagicHandler implements BaseByteCodeHandler{
    @Override
    public int order() {
        return 0;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        classFile.setMagic(new U4(codeBuf.get(),
                codeBuf.get(), codeBuf.get(), codeBuf.get()));
        if (!"0xCAFEBABE".equalsIgnoreCase(classFile.getMagic().toHexString())) {
            throw new Exception("it is not a class file");
        }
    }
}
