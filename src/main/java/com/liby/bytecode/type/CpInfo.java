package com.liby.bytecode.type;

import com.liby.bytecode.handler.ConstantInfoHandler;
import com.liby.bytecode.type.constant.*;

public abstract class CpInfo implements ConstantInfoHandler {

    private U1 tag;

    public CpInfo(U1 tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "tag=" + tag.toString();
    }

    public static CpInfo newCpInfo(U1 tag) throws Exception {
        int tagValue = tag.toInt();
        CpInfo info;
        switch (tagValue) {
            case 1:
                info = new ConstantUTF8Info(tag);
                break;
            case 3:
                info = new ConstantIntegerInfo(tag);
                break;
            case 4:
                info = new ConstantFloatInfo(tag);
                break;
            case 5:
                info = new ConstantLongInfo(tag);
                break;
            case 6:
                info = new ConstantDoubleInfo(tag);
                break;
            case 7:
                info = new ConstantClassInfo(tag);
                break;
            case 8:
                info = new ConstantStringInfo(tag);
                break;
            case 9:
                info = new ConstantFieldRefInfo(tag);
                break;
            case 10:
                info = new ConstantMethodRefInfo(tag);
                break;
            case 11:
                info = new ConstantInterfaceMethodRefInfo(tag);
                break;
            case 12:
                info = new ConstantNameAndTypeInfo(tag);
                break;
            case 15:
                info = new ConstantMethodHandleInfo(tag);
                break;
            case 16:
                info = new ConstantMethodTypeInfo(tag);
                break;
            case 18:
                info = new ConstantInvokeDynamicInfo(tag);
                break;
            default:
                throw new Exception("not found tag:" + tag + " constant value");
        }
        return info;
    }
}
