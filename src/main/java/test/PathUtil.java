package test;

import com.liby.bytecode.ClassFileAnalysisMain;

import java.io.File;
import java.net.URL;
import java.util.Optional;

public class PathUtil {

    private static final String CLASS_STR = ".class";

    public static String getClassPathStr() {
        return getClassPath(RecursionAlgorithm.class);
    }

    public static String getBuilderClassPath() {
        return getClassPath(Builder.class);
    }

    public static String getTestConstantValueInterfaceClassPath() {
        return getClassPath(TestConstantValueInterface.class);
    }

    private static <T> String getClassPath(Class<?> tClass) {
        // Class<?> tClass = t.getClass();
        String pkgName = tClass.getPackage().getName();
        System.out.println("pkgName: " + pkgName);
        String fullPath =Optional.ofNullable(tClass.getClassLoader().getResource(pkgName))
                .map(URL::getPath)
                .map(s -> s.concat(File.separator).concat(tClass.getSimpleName()).concat(CLASS_STR))
                .orElse("");
        System.out.println("fullPath: " + fullPath);
        return fullPath;
    }

    public static void main(String[] args) {
        String name = ClassFileAnalysisMain.class.getPackage().getName();
        System.out.println("name: " + name);
        getClassPathStr();
    }

}
