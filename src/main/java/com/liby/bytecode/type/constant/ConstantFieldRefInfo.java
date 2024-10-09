package com.liby.bytecode.type.constant;

import com.liby.bytecode.type.CpInfo;
import com.liby.bytecode.type.U1;
import com.liby.bytecode.type.U2;

import java.nio.ByteBuffer;

public class ConstantFieldRefInfo extends CpInfo {

    // 表示当前字段所在类的类名
    private U2 class_index;

    // 表示当前字段的名字和方法描述符
    private U2 name_and_type_index;

    public ConstantFieldRefInfo(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        this.class_index = new U2(codeBuf.get(), codeBuf.get());
        this.name_and_type_index = new U2(codeBuf.get(), codeBuf.get());
    }
}
