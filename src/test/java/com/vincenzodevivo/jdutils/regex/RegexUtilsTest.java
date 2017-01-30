package com.vincenzodevivo.jdutils.regex;

import com.vincenzodevivo.jdutils.regex.dsl.ExpressionBuilder;
import com.vincenzodevivo.jdutils.regex.dsl.GroupNameAlreadyDefinedException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by vdevivo on 24/01/2017.
 */
public class RegexUtilsTest {
    private static final Logger logger = LoggerFactory.getLogger(RegexUtilsTest.class);

    @Test
    public void testFindAllInteger() throws Exception {
        List<String> integers = RegexUtils.create().integer().findAll("aaa bbbb -115454 +100 100 1 0 test");
        logger.debug(integers.toString());
        assertArrayEquals(new String[]{"-115454", "+100", "100", "1", "0"}, integers.toArray());
    }

    @Test
    public void testFindFirst() throws Exception {
        String result = RegexUtils
                .create()
                .group()
                .letter().s()
                .space()
                .integer()
                .endGroup()
                .findFirst("aaa bbbb -115454 +100 100 1 0 test");
        logger.debug(result);
        assertEquals("bbbb -115454", result);
    }

    @Test
    public void testFindFirstExactOcc() throws Exception {
        String result = RegexUtils
                .create()
                .group()
                .letter().exactOcc(4)
                .space()
                .integer()
                .endGroup()
                .findFirst("aaa bbbb -115454 +100 100 1 0 test");
        logger.debug(result);
        assertEquals("bbbb -115454", result);
    }

    @Test
    public void testFindFirstAny() throws Exception {
        String result = RegexUtils
                .create()
                .constant("aaa ")
                .group("result")
                .any()
                .endGroup()
                .constant(" 100")
                .findFirst("aaa bbbb -115454 +100 100 1 0 test", "result");
        logger.debug(result);
        assertEquals("bbbb -115454 +100", result);
    }

    @Test(expected = GroupNameAlreadyDefinedException.class)
    public void testGroupNameAlreadyDefined() throws Exception {
        RegexUtils
                .create()
                .group("group1")
                .letter()
                .endGroup()
                .or()
                .group("group1")
                .letter()
                .endGroup()
                .findFirst("aaa bbbb -115454 +100 100 1 0 test", "group1");
    }

    @Test
    public void testFindFirstNamedGroup() throws Exception {
        ExpressionBuilder builder = RegexUtils
                .create()
                .group("group1")
                .letter().s()
                .endGroup()
                .space()
                .group("group2")
                .integer()
                .endGroup();
        String result = builder.findFirst("aaa bbbb -115454 +100 100 1 0 test", "group2");
        logger.debug(result);
        assertEquals("-115454", result);

        result = builder.findFirst("aaa bbbb -115454 +100 100 1 0 test", "group1");
        logger.debug(result);
        assertEquals("bbbb", result);
    }

    @Test
    public void testFindAllByGroupName() throws Exception {
        List<Map<String, String>> results = RegexUtils
                .create()
                .group("group1")
                .letter().s()
                .endGroup()
                .space()
                .group("group2")
                .integer()
                .endGroup()
                .findAllNamedGroup("aaa bbbb -115454 aaa +100 100 1 b 0 test");
        logger.debug(results.toString());

        assertEquals(3, results.size());

        Map<String, String> map = results.get(0);
        assertEquals(2, map.size());
        assertEquals("bbbb", map.get("group1"));
        assertEquals("-115454", map.get("group2"));

        map = results.get(1);
        assertEquals(2, map.size());
        assertEquals("aaa", map.get("group1"));
        assertEquals("+100", map.get("group2"));

        map = results.get(2);
        assertEquals(2, map.size());
        assertEquals("b", map.get("group1"));
        assertEquals("0", map.get("group2"));
    }

    @Test
    public void testFindAll() throws Exception {
        ExpressionBuilder builder = RegexUtils
                .create()
                .letter().s(2, 4);
        List<String> results = builder.findAll("a bb ccc dddd -115454 +100 100 1 b 0");
        logger.debug(builder.toString());
        logger.debug(results.toString());

        assertEquals(3, results.size());
        assertEquals("bb", results.get(0));
        assertEquals("ccc", results.get(1));
        assertEquals("dddd", results.get(2));
    }

    @Test
    public void testFindMap() throws Exception {
        ExpressionBuilder builder = RegexUtils
                .create()
                .group("name")
                    .letter().s()
                .endGroup()
                .constant("=")
                .group("email")
                    .email()
                .endGroup();
        Map<String,String> map = builder.findMap("pippo=pippo@test.com, pluto=pluto@test.com", "name","email");
        logger.debug(builder.toString());
        logger.debug(map.toString());

        assertEquals(2, map.size());
        assertEquals("pluto@test.com", map.get("pluto"));
        assertEquals("pippo@test.com", map.get("pippo"));
    }

    @Test
    public void testFindMapDefaultKey() throws Exception {
        ExpressionBuilder builder = RegexUtils
                .create()
                .group("key")
                    .letter().s()
                .endGroup()
                .constant("=")
                .group("value")
                    .email()
                .endGroup();
        Map<String,String> map = builder.findMap("pippo=pippo@test.com, pluto=pluto@test.com");
        logger.debug(builder.toString());
        logger.debug(map.toString());

        assertEquals(2, map.size());
        assertEquals("pluto@test.com", map.get("pluto"));
        assertEquals("pippo@test.com", map.get("pippo"));
    }
}