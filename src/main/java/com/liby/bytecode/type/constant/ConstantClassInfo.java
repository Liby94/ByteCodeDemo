package com.liby.bytecode.type.constant;

import com.liby.bytecode.type.CpInfo;
import com.liby.bytecode.type.U1;
import com.liby.bytecode.type.U2;

import java.nio.ByteBuffer;

public class ConstantClassInfo extends CpInfo {

    private U2 name_index;

    public ConstantClassInfo(U1 tag) {
        super(tag);
    }

    public U2 getName_index() {
        return name_index;
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        this.name_index = new U2(codeBuf.get(), codeBuf.get());
    }
}
