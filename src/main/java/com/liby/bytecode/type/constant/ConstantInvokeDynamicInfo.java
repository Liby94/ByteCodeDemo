package com.liby.bytecode.type.constant;

import com.liby.bytecode.type.CpInfo;
import com.liby.bytecode.type.U1;
import com.liby.bytecode.type.U2;

import java.nio.ByteBuffer;

public class ConstantInvokeDynamicInfo extends CpInfo {

    private U2 bootstrap_method_attr_index;

    private U2 name_and_type_index;

    public ConstantInvokeDynamicInfo(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        this.bootstrap_method_attr_index = new U2(codeBuf.get(), codeBuf.get());
        this.name_and_type_index = new U2(codeBuf.get(), codeBuf.get());

    }
}
