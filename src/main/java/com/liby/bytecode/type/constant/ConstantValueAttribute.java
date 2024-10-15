package com.liby.bytecode.type.constant;

import com.liby.bytecode.type.U2;
import com.liby.bytecode.type.U4;

public class ConstantValueAttribute {

    private U2 attribute_name_index;
    private U4 attribute_length;
    private U2 constant_value_index;

    public U2 getAttribute_name_index() {
        return attribute_name_index;
    }

    public void setAttribute_name_index(U2 attribute_name_index) {
        this.attribute_name_index = attribute_name_index;
    }

    public U4 getAttribute_length() {
        return attribute_length;
    }

    public void setAttribute_length(U4 attribute_length) {
        this.attribute_length = attribute_length;
    }

    public U2 getConstant_value_index() {
        return constant_value_index;
    }

    public void setConstant_value_index(U2 constant_value_index) {
        this.constant_value_index = constant_value_index;
    }
}
