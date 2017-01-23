package com.vincenzodevivo.jdutils.string;

import junit.framework.TestCase;

/**
 * Created by vdevivo on 23/01/2017.
 */
public class StringCleanerTest extends TestCase implements StringConst {
    public void testTrimMultiline() throws Exception {
        String str = StringCleaner.trimMultiline("\n 1\t\n\t \t2\r\n   3    ");
        assertEquals("1" + NEW_LINE + "2" + NEW_LINE + "3", str);
    }

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
        assertEquals("test" + NEW_LINE + "test" + NEW_LINE + "test", str);
    }
}