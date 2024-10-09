package com.liby.bytecode.type.constant;

import com.liby.bytecode.type.CpInfo;
import com.liby.bytecode.type.U1;
import com.liby.bytecode.type.U2;

import java.nio.ByteBuffer;

public class ConstantMethodTypeInfo extends CpInfo {

    private U2 descriptor_index;

    public ConstantMethodTypeInfo(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        this.descriptor_index = new U2(codeBuf.get(), codeBuf.get());
    }
}
