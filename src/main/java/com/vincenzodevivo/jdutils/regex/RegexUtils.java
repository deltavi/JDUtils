package com.vincenzodevivo.jdutils.regex;

import com.vincenzodevivo.jdutils.regex.dsl.ExpressionBuilder;

/**
 * Created by Vincenzo De Vivo on 22/01/2017.
 */
public class RegexUtils {
    public static ExpressionBuilder create() {
        return new ExpressionBuilder();
    }
}
