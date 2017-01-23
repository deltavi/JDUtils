package com.vincenzodevivo.jdutils.string;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by vdevivo on 23/01/2017.
 */
public class StringCleanerTest implements StringConst {
    private static final Logger logger = LoggerFactory.getLogger(StringCleanerTest.class);

    @Test
    public void testTrimMultiline() throws Exception {
        String str = StringCleaner.trimMultiline("\n 1\t\n\t \t2\r\n   3    ");
        logger.debug(str);
        assertEquals("1" + NEW_LINE + "2" + NEW_LINE + "3", str);
    }

    @Test
    public void testTrimMultiline2() throws Exception {
        String str = StringCleaner.trimMultiline(
                "test\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "test\n" +
                        "\n" +
                        "test");
        logger.debug(str);
        assertEquals("test" + NEW_LINE + "test" + NEW_LINE + "test", str);
    }
}