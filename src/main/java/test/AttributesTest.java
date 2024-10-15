package test;

import com.liby.bytecode.ClassFileAnalysisMain;
import com.liby.bytecode.type.AttributeInfo;
import com.liby.bytecode.type.ClassFile;
import com.liby.bytecode.type.U2;
import com.liby.bytecode.type.constant.ConstantUTF8Info;
import com.liby.bytecode.util.ClassFileAnalysiser;

import java.nio.ByteBuffer;

public class AttributesTest {
    
    private static String getName(U2 name_index, ClassFile classFile) {
        ConstantUTF8Info nameInfo =
                (ConstantUTF8Info) classFile.getConstant_pool()[name_index.toInt() - 1];
        return nameInfo.toString();
    }

    public static void main(String[] args) throws Exception {
        ByteBuffer byteBuffer = ClassFileAnalysisMain.readFile(PathUtil.getBuilderClassPath());
        ClassFile classFile = ClassFileAnalysiser.analysis(byteBuffer);
        System.out.println("属性总数: " + classFile.getAttributes_count().toInt());

        AttributeInfo[] attributes = classFile.getAttributes();
        for (AttributeInfo info : attributes) {
            System.out.println("nameIndex: " + getName(info.getAttribute_name_index(), classFile));
            // info.getAttribute_name_index();
            System.out.println("attributeLength: " + info.getAttribute_length().toInt());
            // info.getAttribute_length();
            System.out.println("info: " + info.getInfo().length);
            // info.getInfo();
        }
    }

}
