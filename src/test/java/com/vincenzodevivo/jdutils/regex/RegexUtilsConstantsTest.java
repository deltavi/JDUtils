package com.vincenzodevivo.jdutils.regex;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by Vincenzo De Vivo on 22/01/2017.
 */
public class RegexUtilsConstantsTest implements RegexConst {
    private static final Logger logger = LoggerFactory.getLogger(RegexUtilsConstantsTest.class);

    @Test
    public void test() {
        validate("info@vincenzodevivo.com", START + EMAIL + END);
        validate("test info@vincenzodevivo.com test", EMAIL);
    }

    @Test
    public void testFail() {
        validateFail("test info@vincenzodevivo.com test", START + EMAIL + END);
    }

    public void validate(String value, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(value);
        logger.debug(matcher.toString());
        assertTrue("Error: value= " + value + ", regex= " + regex, matcher.find());
    }

    public void validateFail(String value, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(value);
        logger.debug(matcher.toString());
        assertFalse("Error: value= " + value + ", regex= " + regex, matcher.find());
    }
}