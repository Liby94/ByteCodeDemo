package test;

import java.io.File;

public class PathUtil {

    public static String getClassPathStr() {
        String pkgName = RecursionAlgorithm.class.getPackage().getName();
        String path = RecursionAlgorithm.class.getClassLoader().getResource(pkgName).getPath();
        return path + File.separator + RecursionAlgorithm.class.getSimpleName() + ".class";
    }

}
