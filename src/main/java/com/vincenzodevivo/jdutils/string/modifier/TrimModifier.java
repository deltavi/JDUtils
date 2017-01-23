package com.vincenzodevivo.jdutils.string.modifier;

/**
 * Created by vdevivo on 23/01/2017.
 */
public class TrimModifier implements StringModifier {
    public String modify(String str) {
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim;
    }
}
