package test;

import com.liby.bytecode.ClassFileAnalysisMain;
import com.liby.bytecode.type.ClassFile;
import com.liby.bytecode.type.FieldInfo;
import com.liby.bytecode.type.U2;
import com.liby.bytecode.type.constant.ConstantUTF8Info;
import com.liby.bytecode.util.ClassFileAnalysiser;
import com.liby.bytecode.util.FieldAccessFlagUtils;

import java.nio.ByteBuffer;

public class FieldHandlerTest {

    private static String getName(U2 name_index, ClassFile classFile) {
        ConstantUTF8Info nameInfo =
                (ConstantUTF8Info) classFile.getConstant_pool()[name_index.toInt() - 1];
        return nameInfo.toString();
    }


    public static void main(String[] args) throws Exception {
        ByteBuffer codeBuf = ClassFileAnalysisMain.readFile(PathUtil.getBuilderClassPath());
        ClassFile classFile = ClassFileAnalysiser.analysis(codeBuf);
        System.out.println("field count: " + classFile.getFields_count().toInt());
        System.out.println();

        FieldInfo[] fields = classFile.getFields();
        for (FieldInfo info : fields) {
            System.out.println("访问标志和属性:" + FieldAccessFlagUtils.toFieldAccessFlagsString(info.getAccess_flags()));
            System.out.println("字段名:" + getName(info.getName_index(), classFile));
            System.out.println("字段的类型描述符:" + getName(info.getDescriptor_index(), classFile));
            System.out.println("属性总数:" + info.getAttributes_count().toInt());
            System.out.println();
        }
    }

}
