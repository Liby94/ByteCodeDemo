package test;

import com.liby.bytecode.ClassFileAnalysisMain;
import com.liby.bytecode.type.AttributeInfo;
import com.liby.bytecode.type.ClassFile;
import com.liby.bytecode.type.FieldInfo;
import com.liby.bytecode.type.U2;
import com.liby.bytecode.type.constant.*;
import com.liby.bytecode.util.AttributeProcessingFactory;
import com.liby.bytecode.util.ClassFileAnalysiser;

import java.nio.ByteBuffer;

public class ConstantValueAttributeTest {

    public static void main(String[] args) throws Exception {
        ByteBuffer byteBuffer = ClassFileAnalysisMain.readFile(
                PathUtil.getTestConstantValueInterfaceClassPath());
        ClassFile classFile = ClassFileAnalysiser.analysis(byteBuffer);
        // 获取所有字段
        FieldInfo[] fieldInfos = classFile.getFields();
        System.out.println("fieldInfos length: " + fieldInfos.length);
        for (FieldInfo info : fieldInfos) {
            // 获取字段的所有属性
            AttributeInfo[] attributeInfos = info.getAttributes();
            if (attributeInfos == null || attributeInfos.length == 0) {
            System.out.println("attributeInfos is empty!" );
                continue;
            }
            System.out.println("字段: " + classFile.getConstant_pool()[info.getName_index().toInt() - 1]);
            for (AttributeInfo attributeInfo : attributeInfos) {
                // 获取属性的名称
                U2 name_index = attributeInfo.getAttribute_name_index();
                ConstantUTF8Info name_info =
                        (ConstantUTF8Info) classFile.getConstant_pool()[name_index.toInt() - 1];
                String name = new String(name_info.getBytes());
                // 如果属性名是ConstantValue，则对该属性进行二次解析
                if (name.equalsIgnoreCase("ConstantValue")) {
                    // 属性二次解析
                    ConstantValueAttribute constantValue =
                            AttributeProcessingFactory.processingConstantValue(attributeInfo);
                    // 取得Constantvalue_index,从常量池中取值
                    U2  cv_index = constantValue.getConstant_value_index();
                    Object cv = classFile.getConstant_pool()[cv_index.toInt() - 1];
                    // 需要判断常量的类型
                    if (cv instanceof ConstantUTF8Info) {
                        System.out.println("ConstantValue: " + cv.toString());
                    } else if (cv instanceof ConstantIntegerInfo) {
                        System.out.println("ConstantValue: " + (((ConstantIntegerInfo)cv).getBytes().toInt()));
                    } else if (cv instanceof ConstantFloatInfo) {
                        // todo
                    } else if (cv instanceof ConstantLongInfo) {
                        // todo
                    } else if (cv instanceof ConstantDoubleInfo) {
                        // todo
                    }
                }


            }
        }

    }

}
