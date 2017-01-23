package com.vincenzodevivo.jdutils.string;

import com.vincenzodevivo.jdutils.string.modifier.TrimModifier;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by vdevivo on 23/01/2017.
 */
public class StringSplitterTest {
    private static final Logger logger = LoggerFactory.getLogger(StringSplitterTest.class);

    @Test
    public void testSplitAndModifyElements() throws Exception {
        List<String> elements = StringSplitter.splitAndModify(" a |b|\t c|", "|", new TrimModifier());
        logger.debug(elements.toString());
        assertEquals("Element size != 3", 3, elements.size());
        assertEquals("a", elements.get(0));
        assertEquals("b", elements.get(1));
        assertEquals("c", elements.get(2));
    }

    @Test
    public void testSplitAndModifyElements2() throws Exception {
        List<String> elements = StringSplitter.splitAndModify(" a |b|\t c", "|b|\t", new TrimModifier());
        logger.debug(elements.toString());
        assertEquals("Element size != 2", 2, elements.size());
        assertEquals("a", elements.get(0));
        assertEquals("c", elements.get(1));
    }

    @Test
    public void testSplitAndModifyElements_StrNull() throws Exception {
        List<String> elements = StringSplitter.splitAndModify(null, "|b|\t", new TrimModifier());
        logger.debug(elements.toString());
        assertEquals("Element size != 0", 0, elements.size());
    }

    @Test
    public void testSplitAndModifyElementsRE() throws Exception {
        List<String> elements = StringSplitter.splitAndModifyRE(" a |b|\t c|", "\\|", new TrimModifier());
        logger.debug(elements.toString());
        assertEquals("Element size != 3", 3, elements.size());
        assertEquals("a", elements.get(0));
        assertEquals("b", elements.get(1));
        assertEquals("c", elements.get(2));
    }

    @Test
    public void testSplitAndModifyElementsRE2() throws Exception {
        List<String> elements = StringSplitter.splitAndModifyRE("a12b5c", "\\d", new TrimModifier());
        logger.debug(elements.toString());
        assertEquals("Element size != 3", 3, elements.size());
        assertEquals("a", elements.get(0));
        assertEquals("b", elements.get(1));
        assertEquals("c", elements.get(2));
    }

    @Test
    public void testSplitAndModifyElementsRE_StrNull() throws Exception {
        List<String> elements = StringSplitter.splitAndModifyRE(null, "\\d", new TrimModifier());
        logger.debug(elements.toString());
        assertEquals("Element size != 0", 0, elements.size());
    }

    @Test
    public void testSplitAndModifyElementsRE_ReNull() throws Exception {
        List<String> elements = StringSplitter.splitAndModifyRE("xx", null, new TrimModifier());
        logger.debug(elements.toString());
        assertEquals("Element size != 0", 0, elements.size());
    }
}