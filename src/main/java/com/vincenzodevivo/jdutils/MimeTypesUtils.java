package com.vincenzodevivo.jdutils;

import javax.activation.MimetypesFileTypeMap;

/**
 * Created by Vincenzo De Vivo on 19/01/2017.
 */
public class MimeTypesUtils {
    /**
     * Get content type from file extension
     * @param fileName
     * @return content type
     */
    public static String getFileContentType(final String fileName) {
        return MimetypesFileTypeMap
                .getDefaultFileTypeMap()
                .getContentType(fileName.toLowerCase());
    }
}
