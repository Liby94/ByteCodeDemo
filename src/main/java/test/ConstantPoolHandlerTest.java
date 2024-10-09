package test;

import com.liby.bytecode.ClassFileAnalysisMain;
import com.liby.bytecode.type.ClassFile;
import com.liby.bytecode.type.CpInfo;
import com.liby.bytecode.util.ClassFileAnalysiser;

import java.io.File;
import java.nio.ByteBuffer;

public class ConstantPoolHandlerTest {


    public static void main(String[] args) throws Exception{
        System.out.println(RecursionAlgorithm.class.getName());
        String name = RecursionAlgorithm.class.getPackage().getName();
        System.out.println(name);
        String path = RecursionAlgorithm.class.getClassLoader().getResource(name).getPath();
        System.out.println(path);
        ByteBuffer byteBuffer = ClassFileAnalysisMain.readFile(path +
                File.separator + RecursionAlgorithm.class.getSimpleName() + ".class");
        ClassFile classFile = ClassFileAnalysiser.analysis(byteBuffer);

        int cp_info_count = classFile.getConstant_pool_count().toInt();
        System.out.println("constant pool count: " + cp_info_count);

        CpInfo[] cpInfos = classFile.getConstant_pool();
        for (CpInfo info : cpInfos) {
            System.out.println(info.toString());
        }
    }
}
