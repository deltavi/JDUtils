package com.vincenzodevivo.jdutils.regex;

import junit.framework.TestCase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Vincenzo De Vivo on 22/01/2017.
 */
public class RegexUtilsConstantsTest extends TestCase implements RegexConst {

    public void test() {
        validate("info@vincenzodevivo.com", START + EMAIL + END);
        validate("test info@vincenzodevivo.com test", EMAIL);
    }

    public void testFail() {
        validateFail("test info@vincenzodevivo.com test", START + EMAIL + END);
    }

    public void validate(String value, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(value);
        assertTrue("Error: value= " + value + ", regex= " + regex, matcher.find());
    }

    public void validateFail(String value, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(value);
        assertTrue("Error: value= " + value + ", regex= " + regex, !matcher.find());
    }
}