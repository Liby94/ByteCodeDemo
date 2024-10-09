package com.liby.bytecode.type.constant;

import com.liby.bytecode.type.CpInfo;
import com.liby.bytecode.type.U1;
import com.liby.bytecode.type.U4;

import java.nio.ByteBuffer;

public class ConstantIntegerInfo extends CpInfo {

    private U4 bytes;

    public ConstantIntegerInfo(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        bytes = new U4(codeBuf.get(), codeBuf.get(), codeBuf.get(), codeBuf.get());
    }
}
