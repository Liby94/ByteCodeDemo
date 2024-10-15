package com.liby.bytecode.util;

import com.liby.bytecode.type.AttributeInfo;
import com.liby.bytecode.type.U2;
import com.liby.bytecode.type.constant.ConstantValueAttribute;

public class AttributeProcessingFactory {

    public static ConstantValueAttribute processingConstantValue(AttributeInfo attributeInfo) {
        ConstantValueAttribute attribute = new ConstantValueAttribute();
        attribute.setAttribute_name_index(attributeInfo.getAttribute_name_index());
        attribute.setAttribute_length(attributeInfo.getAttribute_length());
        attribute.setConstant_value_index(new U2(attributeInfo.getInfo()[0], attributeInfo.getInfo()[1]));
        return attribute;
    }

}
