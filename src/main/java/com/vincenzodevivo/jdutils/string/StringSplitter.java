package com.vincenzodevivo.jdutils.string;

import com.vincenzodevivo.jdutils.string.modifier.StringModifier;
import com.vincenzodevivo.jdutils.string.modifier.TrimModifier;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by vdevivo on 23/01/2017.
 */
public class StringSplitter {
    public static List<String> splitAndModify(String str, String delimiter, StringModifier modifier) {
        return splitAndModifyRE(str, Pattern.quote(delimiter), modifier);
    }

    public static List<String> splitAndModifyRE(String str, String regEx, StringModifier modifier) {
        List<String> elements = new ArrayList<>();
        if (str != null && str.length() > 0 && regEx != null) {
            String[] arr = str.split(regEx);
            for (String element : arr) {
                String newElement = modifier.modify(element);
                if (newElement != null) {
                    elements.add(newElement);
                }
            }
        }
        return elements;
    }

    public static List<String> splitAndTrim(String str, String delimiter) {
        return splitAndTrimRE(str, Pattern.quote(delimiter));
    }

    public static List<String> splitAndTrimRE(String str, String regEx) {
        return splitAndModifyRE(str, regEx, new TrimModifier());
    }
}
