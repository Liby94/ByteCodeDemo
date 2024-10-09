package test;

import com.liby.bytecode.ClassFileAnalysisMain;
import com.liby.bytecode.type.ClassFile;
import com.liby.bytecode.type.U2;
import com.liby.bytecode.util.ClassAccessFlagUtils;
import com.liby.bytecode.util.ClassFileAnalysiser;

import java.io.File;
import java.nio.ByteBuffer;

public class AccessFlagHandlerTest {

    public static void main(String[] args) throws Exception {
        String pkgName = RecursionAlgorithm.class.getPackage().getName();
        String path = RecursionAlgorithm.class.getClassLoader().getResource(pkgName).getPath();

        ByteBuffer byteBuffer = ClassFileAnalysisMain.readFile(path
                + File.separator + RecursionAlgorithm.class.getSimpleName() + ".class");
        ClassFile classFile = ClassFileAnalysiser.analysis(byteBuffer);
        // 获取访问标志
        U2 accessFlags = classFile.getAccess_flags();
        // 输出为字符串
        System.out.println(ClassAccessFlagUtils.toClassAccessFlagString(accessFlags));
    }

}
