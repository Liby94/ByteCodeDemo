package com.liby.bytecode.type.constant;

import com.liby.bytecode.type.CpInfo;
import com.liby.bytecode.type.U1;
import com.liby.bytecode.type.U2;

import java.nio.ByteBuffer;

public class ConstantNameAndTypeInfo extends CpInfo {

    private U2 name_index;

    private U2 desciptor_index;

    public ConstantNameAndTypeInfo(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        // 名称索引
        this.name_index = new U2(codeBuf.get(), codeBuf.get());
        // 描述符索引
        this.desciptor_index = new U2(codeBuf.get(), codeBuf.get());
    }
}
