package com.vincenzodevivo.jdutils.string;

import com.vincenzodevivo.jdutils.regex.RegexConst;

import java.util.StringTokenizer;

/**
 * Created by vdevivo on 23/01/2017.
 */
public class StringCleaner implements StringConst {

    public static String trimMultiline(String str) {
        StringBuilder stringBuffer = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(str, "\n");
        while (stringTokenizer.hasMoreElements()) {
            String line = stringTokenizer.nextToken();
            String newLine = line.trim();
            if (newLine.length() > 0) {
                stringBuffer.append(newLine);
                if (stringTokenizer.hasMoreElements()) {
                    stringBuffer.append(NEW_LINE);
                }
            }
        }
        return stringBuffer.toString().trim();
    }
}




