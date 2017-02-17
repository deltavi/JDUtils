package com.vincenzodevivo.jdutils.file;

/**
 * Created by vdevivo on 17/02/2017.
 */
public class FileUtils {
    public static final char EXT_SEPARATOR = '.';

    public static String removeExtension(final String fileName) {
        if (fileName == null) {
            return null;
        }
        int index = fileName.lastIndexOf(EXT_SEPARATOR);
        if (index == -1) {
            return fileName;
        } else {
            return fileName.substring(0, index);
        }
    }

    public static String changeExtension(final String fileName, final String newExtension) {
        String name = removeExtension(fileName);
        if (name == null) {
            return null;
        } else if (name.length() == 0) {
            return fileName;
        }

        return name + EXT_SEPARATOR + newExtension;
    }
}
