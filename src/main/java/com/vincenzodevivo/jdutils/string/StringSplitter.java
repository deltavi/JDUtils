package com.vincenzodevivo.jdutils.string;

import com.vincenzodevivo.jdutils.string.modifier.StringModifier;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by vdevivo on 23/01/2017.
 */
public class StringSplitter {
    public static List<String> splitAndModifyElements(String str, String delim, StringModifier modifier) {
        List<String> elements = new ArrayList<String>();
        StringTokenizer stringTokenizer = new StringTokenizer(str, delim);
        while (stringTokenizer.hasMoreElements()) {
            String element = stringTokenizer.nextToken();
            String newElement = modifier.modify(element);
            if (newElement != null) {
                elements.add(newElement);
            }
        }
        return elements;
    }
}
