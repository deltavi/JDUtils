package com.vincenzodevivo.jdutils.string;

import com.vincenzodevivo.jdutils.string.modifier.TrimModifier;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by vdevivo on 23/01/2017.
 */
public class StringSplitterTest extends TestCase {
    public void testSplitAndModifyElements() throws Exception {
        List<String> elements = StringSplitter.splitAndModifyElements(" a |b|\t c|", "|", new TrimModifier());
        assertEquals("Element size != 3", 3, elements.size());
        assertEquals("a", elements.get(0));
        assertEquals("b", elements.get(1));
        assertEquals("c", elements.get(2));
    }
}