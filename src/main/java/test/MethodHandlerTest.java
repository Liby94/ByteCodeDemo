package test;

import com.liby.bytecode.ClassFileAnalysisMain;
import com.liby.bytecode.type.ClassFile;
import com.liby.bytecode.type.MethodInfo;
import com.liby.bytecode.type.U2;
import com.liby.bytecode.type.constant.ConstantUTF8Info;
import com.liby.bytecode.util.ClassFileAnalysiser;
import com.liby.bytecode.util.FieldAccessFlagUtils;

import java.nio.ByteBuffer;

public class MethodHandlerTest {

    private static String getName(U2 name_index, ClassFile classFile) {
        ConstantUTF8Info nameInfo =
                (ConstantUTF8Info) classFile.getConstant_pool()[name_index.toInt() - 1];
        return nameInfo.toString();
    }

    public static void main(String[] args) throws Exception {
        ByteBuffer codeBuf = ClassFileAnalysisMain.readFile(PathUtil.getBuilderClassPath());
        ClassFile classFile = ClassFileAnalysiser.analysis(codeBuf);
        System.out.println("method count: " + classFile.getMethods_count().toInt());
        System.out.println();

        MethodInfo[] methods = classFile.getMethods();
        // 遍历方法表
        for (MethodInfo method : methods) {
            System.out.println("访问标志和属性：" +
                    FieldAccessFlagUtils.toFieldAccessFlagsString(method.getAccess_flags()));

            System.out.println("方法名: " + getName(method.getName_index(), classFile));

            System.out.println("方法描述符: " + getName(method.getDescriptor_index(), classFile));

            System.out.println("属性总数: " + method.getAttributes_count().toInt());
            System.out.println();
        }

    }

}
