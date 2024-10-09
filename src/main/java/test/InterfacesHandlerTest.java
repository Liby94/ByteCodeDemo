package test;

import com.liby.bytecode.ClassFileAnalysisMain;
import com.liby.bytecode.type.ClassFile;
import com.liby.bytecode.type.U2;
import com.liby.bytecode.type.constant.ConstantClassInfo;
import com.liby.bytecode.type.constant.ConstantUTF8Info;
import com.liby.bytecode.util.ClassFileAnalysiser;

import java.nio.ByteBuffer;

public class InterfacesHandlerTest {

    public static void main(String[] args) throws Exception {
        ByteBuffer byteBuffer = ClassFileAnalysisMain.readFile(PathUtil.getClassPathStr());
        ClassFile classFile = ClassFileAnalysiser.analysis(byteBuffer);
        System.out.println("interface count: " + classFile.getInterfaces_count().toInt());

        if (classFile.getInterfaces_count().toInt() == 0) {
            return;
        }

        U2[] interfaces = classFile.getInterfaces();

        for (U2 interfaceIndex : interfaces) {
            // 根据索引从常量池中取得一个 ConstantClassInfo 常量
            ConstantClassInfo interfaceClassInfo =
                    (ConstantClassInfo) classFile.getConstant_pool()[interfaceIndex.toInt() - 1];

            // 根据 ConstantClassInfo的name_index从常量池取得一个ConstantUTF8Info常量
            ConstantUTF8Info interfaceClassNameInfo =
                    (ConstantUTF8Info) classFile.getConstant_pool()[interfaceClassInfo.getName_index().toInt() - 1];
            System.out.println(interfaceClassNameInfo);

        }

    }

}
