package com.liby.bytecode.handler;

import com.liby.bytecode.type.*;

import java.nio.ByteBuffer;

public class FieldHandler implements BaseByteCodeHandler {

    @Override
    public int order() {
        return 6;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        // 读取字段总数
        classFile.setFields_count(new U2(codeBuf.get(), codeBuf.get()));
        int len = classFile.getFields_count().toInt();
        if (len == 0) {
            System.out.println("filed count is zero!");
            return;
        }
        // 创建字段表
        FieldInfo[] fieldInfos = new FieldInfo[len];
        classFile.setFields(fieldInfos);
        for (int i = 0; i < len; i++) {
            // 解析字段
            fieldInfos[i] = new FieldInfo();
            // 读取字段的访问标志
            fieldInfos[i].setAccess_flags(new U2(codeBuf.get(), codeBuf.get()));
            //读取字段名称
            fieldInfos[i].setName_index(new U2(codeBuf.get(), codeBuf.get()));
            // 读取字段类型描述符索引
            fieldInfos[i].setDescriptor_index(new U2(codeBuf.get(), codeBuf.get()));
            // 读取字段的属性总数
            fieldInfos[i].setAttributes_count(new U2(codeBuf.get(), codeBuf.get()));
            // 获取字段的属性总数
            int attr_len = fieldInfos[i].getAttributes_count().toInt();
            if (attr_len == 0) {
                continue;
            }
            fieldInfos[i].setAttributes(new AttributeInfo[attr_len]);
            for (int j = 0; j < attr_len; j++) {
                fieldInfos[i].getAttributes()[j] = new AttributeInfo();
                // 解析字段的属性
                fieldInfos[i].getAttributes()[j].setAttribute_name_index(
                        new U2(codeBuf.get(), codeBuf.get()));
                // 获取属性info的长度
                U4 attr_info_len = new U4(codeBuf.get(), codeBuf.get(), codeBuf.get(), codeBuf.get());
                fieldInfos[i].getAttributes()[j].setAttribute_length(attr_info_len);
                if (attr_info_len.toInt() == 0) {
                    continue;
                }
                // 解析info
                byte[] info = new byte[attr_info_len.toInt()];
                codeBuf.get(info, 0, attr_info_len.toInt());
                fieldInfos[i].getAttributes()[j].setInfo(info);

            }
        }
    }
}
