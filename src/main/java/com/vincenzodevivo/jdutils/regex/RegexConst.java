package com.vincenzodevivo.jdutils.regex;

/**
 * Created by Vincenzo De Vivo on 22/01/2017.
 */
public interface RegexConst {
    String LETTER = "[a-zA-Z]";
    String INTEGER = "([+-]?[1-9]\\d*|0)";
    String DIGITS = "\\d+";
    String DIGIT = "\\d";
    String NUMBER = "\\d+(\\.\\d+)?";
    String EMAIL = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}";
    String NEW_LINE = "(\r\n|\n)";
    String ANY = ".*";
    String START = "^";
    String END = "$";
    String OR = "|";
    String OCC_ZERO_OR_ONE = "?";
    String OCC_ZERO_OR_MORE = "*";
    String OCC_ONE_OR_MORE = "+";
    String OCC_TWO_OR_MORE = "{2,}";
}
