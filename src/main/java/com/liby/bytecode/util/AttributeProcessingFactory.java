package com.liby.bytecode.util;

import com.liby.bytecode.type.AttributeInfo;
import com.liby.bytecode.type.CodeAttribute;
import com.liby.bytecode.type.U2;
import com.liby.bytecode.type.U4;
import com.liby.bytecode.type.constant.ConstantValueAttribute;

import java.nio.ByteBuffer;

public class AttributeProcessingFactory {

    public static ConstantValueAttribute processingConstantValue(AttributeInfo attributeInfo) {
        ConstantValueAttribute attribute = new ConstantValueAttribute();
        attribute.setAttribute_name_index(attributeInfo.getAttribute_name_index());
        attribute.setAttribute_length(attributeInfo.getAttribute_length());
        attribute.setConstant_value_index(new U2(attributeInfo.getInfo()[0], attributeInfo.getInfo()[1]));
        return attribute;
    }

    public static CodeAttribute processingCode(AttributeInfo attributeInfo) {
        CodeAttribute codeAttribute = new CodeAttribute();
        ByteBuffer byteBuffer = ByteBuffer.wrap(attributeInfo.getInfo());
        // 操作数栈大小
        codeAttribute.setMax_stack(new U2(byteBuffer.get(), byteBuffer.get()));
        // 局部变量表大小
        codeAttribute.setMax_locals(new U2(byteBuffer.get(), byteBuffer.get()));
        // 字节码数组长度
        codeAttribute.setCode_length(new U4(
                byteBuffer.get(), byteBuffer.get(), byteBuffer.get(), byteBuffer.get()));

        // 解析获取字节码
        byte[] byteCode = new byte[codeAttribute.getCode_length().toInt()];
        byteBuffer.get(byteCode, 0, byteCode.length);
        codeAttribute.setCode(byteCode);
        byteBuffer.clear();
        return codeAttribute;
    }

}
