package test;

import com.liby.bytecode.ClassFileAnalysisMain;
import com.liby.bytecode.type.*;
import com.liby.bytecode.type.constant.ConstantUTF8Info;
import com.liby.bytecode.util.AttributeProcessingFactory;
import com.liby.bytecode.util.ClassFileAnalysiser;
import com.liby.bytecode.util.HexUtil;

import java.nio.ByteBuffer;

public class CodeAttributeTest {

    public static void main(String[] args) throws Exception {
        ByteBuffer byteBuffer = ClassFileAnalysisMain.readFile(PathUtil.getClassPathStr());
        ClassFile classFile = ClassFileAnalysiser.analysis(byteBuffer);
        // 获取方法表
        MethodInfo[] methodInfos = classFile.getMethods();
        for (MethodInfo info : methodInfos) {
            // 获取方法的属性表
            AttributeInfo[] attributes = info.getAttributes();
            if (attributes == null || attributes.length == 0) {
                continue;
            }
            System.out.println("方法: " + classFile.getConstant_pool()[info.getName_index().toInt() - 1]);

            // 遍历属性表
            for (AttributeInfo attribute : attributes) {
                // 获取属性的名称
                U2 name_index = attribute.getAttribute_name_index();
                ConstantUTF8Info name_info =
                        (ConstantUTF8Info) classFile.getConstant_pool()[name_index.toInt() - 1];
                String name = new String(name_info.getBytes());
                // 对code属性二次解析
                if (name.equalsIgnoreCase("Code")) {
                    // 属性二次解析
                    CodeAttribute codeAttribute = AttributeProcessingFactory.processingCode(attribute);
                    System.out.println("操作数栈大小:" + codeAttribute.getMax_stack().toInt());
                    System.out.println("局部变量表大小:" + codeAttribute.getMax_locals().toInt());
                    System.out.println("字节码数组长度:" + codeAttribute.getCode_length().toInt());
//                    System.out.println("字节码:" );
//                    for (byte b : codeAttribute.getCode()) {
//                        System.out.print((b & 0xff) + " ");
//                    }
                    System.out.println("字节码: \n" + HexUtil.toHexString(codeAttribute.getCode()));
                    System.out.println("\n");
                }
            }
        }
    }

}
