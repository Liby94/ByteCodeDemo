package test;

import com.liby.bytecode.ClassFileAnalysisMain;
import com.liby.bytecode.type.ClassFile;
import com.liby.bytecode.type.U2;
import com.liby.bytecode.type.constant.ConstantClassInfo;
import com.liby.bytecode.type.constant.ConstantUTF8Info;
import com.liby.bytecode.util.ClassFileAnalysiser;

import java.nio.ByteBuffer;

public class ThisAndSuperHandlerTest {

    public static void main(String[] args) throws Exception {
        String classPathStr = PathUtil.getClassPathStr();
        ByteBuffer byteBuffer = ClassFileAnalysisMain.readFile(classPathStr);
        ClassFile classFile = ClassFileAnalysiser.analysis(byteBuffer);
        // 根据thisClass到常量池获取ConstantClassInfo常量
        U2 thisClass = classFile.getThis_class();
        // 常量池索引是从1开始的，需要将索引减1取得数组下标
        ConstantClassInfo thisClassInfo = (ConstantClassInfo) classFile.getConstant_pool()[thisClass.toInt() - 1];
        ConstantUTF8Info thisClassName =
                (ConstantUTF8Info) classFile.getConstant_pool()[thisClassInfo.getName_index().toInt() - 1];
        System.out.println(thisClassName);

        U2 superClass = classFile.getSuper_class();
        ConstantClassInfo superClassInfo =
                (ConstantClassInfo) classFile.getConstant_pool()[superClass.toInt() - 1];
        ConstantUTF8Info superClassName =
                (ConstantUTF8Info) classFile.getConstant_pool()[superClassInfo.getName_index().toInt() - 1];
        System.out.println(superClassName);
    }
}
