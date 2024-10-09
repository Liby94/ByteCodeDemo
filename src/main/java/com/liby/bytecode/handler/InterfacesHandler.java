package com.liby.bytecode.handler;

import com.liby.bytecode.type.ClassFile;
import com.liby.bytecode.type.U2;

import java.nio.ByteBuffer;

public class InterfacesHandler implements BaseByteCodeHandler {

    @Override
    public int order() {
        return 5;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        classFile.setInterfaces_count(new U2(codeBuf.get(), codeBuf.get()));
        int interfaceCount = classFile.getInterfaces_count().toInt();
        U2[] interfaces = new U2[interfaceCount];
        classFile.setInterfaces(interfaces);
        for (int i = 0; i < interfaceCount; i++) {
            interfaces[i] = new U2(codeBuf.get(), codeBuf.get());
        }
    }
}
