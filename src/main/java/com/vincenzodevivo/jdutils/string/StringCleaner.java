package com.vincenzodevivo.jdutils.string;

import com.vincenzodevivo.jdutils.regex.RegexConst;

/**
 * Created by vdevivo on 23/01/2017.
 */
public class StringCleaner implements StringConst {
    public static String trimMultiline(String str) {
        if (str != null && str.length() > 0) {
            StringBuilder stringBuffer = new StringBuilder();
            String[] arr = str.split(RegexConst.NEW_LINE);
            for (int i = 0; i < arr.length; i++) {
                String element = arr[i].trim();
                if (element.length() > 0) {
                    if (stringBuffer.length() > 0) {
                        stringBuffer.append(NEW_LINE);
                    }
                    stringBuffer.append(element);
                }
            }
            return stringBuffer.toString();
        }
        return null;
    }
}




