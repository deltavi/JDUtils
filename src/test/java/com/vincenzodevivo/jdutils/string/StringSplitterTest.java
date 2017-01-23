package com.vincenzodevivo.jdutils.string;

import com.vincenzodevivo.jdutils.string.modifier.TrimModifier;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by vdevivo on 23/01/2017.
 */
public class StringSplitterTest extends TestCase {
    public void testSplitAndModifyElements() throws Exception {
        List<String> elements = StringSplitter.splitAndModify(" a |b|\t c|", "|", new TrimModifier());
        assertEquals("Element size != 3", 3, elements.size());
        assertEquals("a", elements.get(0));
        assertEquals("b", elements.get(1));
        assertEquals("c", elements.get(2));
    }

    public void testSplitAndModifyElements2() throws Exception {
        List<String> elements = StringSplitter.splitAndModify(" a |b|\t c", "|b|\t", new TrimModifier());
        assertEquals("Element size != 2", 2, elements.size());
        assertEquals("a", elements.get(0));
        assertEquals("c", elements.get(1));
    }

    public void testSplitAndModifyElements_StrNull() throws Exception {
        List<String> elements = StringSplitter.splitAndModify(null, "|b|\t", new TrimModifier());
        assertEquals("Element size != 0", 0, elements.size());
    }

    public void testSplitAndModifyElementsRE() throws Exception {
        List<String> elements = StringSplitter.splitAndModifyRE(" a |b|\t c|", "\\|", new TrimModifier());
        assertEquals("Element size != 3", 3, elements.size());
        assertEquals("a", elements.get(0));
        assertEquals("b", elements.get(1));
        assertEquals("c", elements.get(2));
    }

    public void testSplitAndModifyElementsRE2() throws Exception {
        List<String> elements = StringSplitter.splitAndModifyRE("a12b5c", "\\d", new TrimModifier());
        assertEquals("Element size != 3", 3, elements.size());
        assertEquals("a", elements.get(0));
        assertEquals("b", elements.get(1));
        assertEquals("c", elements.get(2));
    }

    public void testSplitAndModifyElementsRE_StrNull() throws Exception {
        List<String> elements = StringSplitter.splitAndModifyRE(null, "\\d", new TrimModifier());
        assertEquals("Element size != 0", 0, elements.size());
    }

    public void testSplitAndModifyElementsRE_ReNull() throws Exception {
        List<String> elements = StringSplitter.splitAndModifyRE("xx", null, new TrimModifier());
        assertEquals("Element size != 0", 0, elements.size());
    }
}