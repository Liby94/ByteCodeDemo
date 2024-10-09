package test;

import com.liby.bytecode.ClassFileAnalysisMain;
import com.liby.bytecode.type.ClassFile;
import com.liby.bytecode.util.ClassFileAnalysiser;

import java.io.File;
import java.nio.ByteBuffer;

public class MagicAndVersionTest {

    public static void main(String[] args) throws Exception {
        String pkgName = MagicAndVersionTest.class.getPackage().getName();
        String path1 = MagicAndVersionTest.class.getClassLoader().getResource(pkgName).getPath();
        String path = Thread.currentThread().getContextClassLoader().getResource(pkgName).getPath();
        System.out.println("path: " + path + ",package path: " + pkgName + ",path1:" + path1);
        ByteBuffer codeBuf = ClassFileAnalysisMain.readFile(path + File.separator + "RecursionAlgorithm.class");
        ClassFile classFile = ClassFileAnalysiser.analysis(codeBuf);
        System.out.println(classFile.getMagic().toHexString());
        System.out.println(classFile.getMinor_version().toHexString());
        System.out.println("majorVersion: " + classFile.getMajor_version().toHexString());
    }

}
