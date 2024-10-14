package test;

import com.liby.bytecode.ClassFileAnalysisMain;

import java.io.File;

public class PathUtil {

    public static String getClassPathStr() {
        String pkgName = RecursionAlgorithm.class.getPackage().getName();
        System.out.println("pkgName: " + pkgName);
        String path = RecursionAlgorithm.class.getClassLoader().getResource(pkgName).getPath();
        String fullPath = path + File.separator + RecursionAlgorithm.class.getSimpleName() + ".class";
        System.out.println("fullPath: " + fullPath);
        return fullPath;
    }

    public static String getBuilderClassPath() {
        String pkgName = Builder.class.getPackage().getName();
        System.out.println("pkgName: " + pkgName);
        String path = Builder.class.getClassLoader().getResource(pkgName).getPath();
        String fullPath = path + File.separator + Builder.class.getSimpleName() + ".class";
        System.out.println("fullPath: " + fullPath);
        return fullPath;
    }

    public static void main(String[] args) {
        String name = ClassFileAnalysisMain.class.getPackage().getName();
        System.out.println("name: " + name);
        getClassPathStr();
    }

}
