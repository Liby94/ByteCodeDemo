package com.liby.bytecode.util;

import com.liby.bytecode.type.U2;

import java.util.HashMap;
import java.util.Map;

public class ClassAccessFlagUtils {

    private static final Map<Integer, String> classAccessFlagMap = new HashMap<>();

    /**
     标志名	            值	        描述
     ACC_PUBLIC	        0x0001	    声明为public
     ACC_FINAL	        0x0010	    声明为final，不允许继承
     ACC_SUPER	        0x0020	    Jdk1.0.2之后编译的class文件都会有此值
     ACC_INTERFACE	    0x0200	    声明该class是接口
     ACC_ABSTRACT	    0x0400	    声明为抽象类
     ACC_SYNTHETIC	    0x1000	    表示该class文件并非由java代码编译生成
     ACC_ANNOTATION	    0x2000	    标志这是一个注解类型
     ACC_ENUM	        0x4000	    标志这是一个枚举类型
     */
    static {
        classAccessFlagMap.put(0x0001, "public");
        classAccessFlagMap.put(0x0010, "final");
        classAccessFlagMap.put(0x0020, "super");
        classAccessFlagMap.put(0x0200, "interface");
        classAccessFlagMap.put(0x0400, "abstract");
        // 该class非java代码编译后生成
        classAccessFlagMap.put(0x1000, "synthetic");
        classAccessFlagMap.put(0x2000, "annotation");
        classAccessFlagMap.put(0x4000, "enum");
    }

    public static String toClassAccessFlagString(U2 flag) {
        final int flagValue = flag.toInt();
        StringBuilder flagBuild = new StringBuilder();
        classAccessFlagMap.keySet().forEach(key -> {
            if ((flagValue & key) == key) {
                flagBuild.append(classAccessFlagMap.get(key)).append(",");
            }
        });
        return flagBuild.length() > 0 && flagBuild.charAt(flagBuild.length() - 1) == ',' ?
                flagBuild.substring(0, flagBuild.length() - 1) : flagBuild.toString();
    }

}
