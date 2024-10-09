package com.liby.bytecode.util;

import com.liby.bytecode.handler.*;
import com.liby.bytecode.type.ClassFile;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClassFileAnalysiser {

    private final static List<BaseByteCodeHandler> handlers =
            new ArrayList<>();

    static {
        handlers.add(new InterfacesHandler());
        handlers.add(new ThisAndSuperHandler());
        handlers.add(new ConstantPoolHandler());
        handlers.add(new AccessFlagHandler());
        handlers.add(new MagicHandler());
        handlers.add(new VersionHandler());
        handlers.sort(Comparator.comparingInt(BaseByteCodeHandler::order));
    }

    public static ClassFile analysis(ByteBuffer codeBuf) throws Exception {
        // 重置ByteBuffer的读指针，从头开始
        codeBuf.position(0);
        ClassFile classFile = new ClassFile();
        for (BaseByteCodeHandler handler: handlers) {
            handler.read(codeBuf, classFile);
        }
        return classFile;
    }

}
