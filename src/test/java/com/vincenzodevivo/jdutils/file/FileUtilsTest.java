package com.vincenzodevivo.jdutils.file;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by vdevivo on 17/02/2017.
 */
public class FileUtilsTest {
    @Test
    public void removeExtension() throws Exception {
        String name = FileUtils.removeExtension("test.1.0.0.txt");
        assertEquals("test.1.0.0", name);
    }

    @Test
    public void removeExtensionEmpty() throws Exception {
        String name = FileUtils.removeExtension(null);
        assertNull(name);
        name = FileUtils.removeExtension("");
        assertEquals("", name);
    }

    @Test
    public void changeExtension() throws Exception {
        String fileName = FileUtils.changeExtension("test.1.0.0.txt", "xml");
        assertEquals("test.1.0.0.xml", fileName);
    }

    @Test
    public void changeExtensionEmpty() throws Exception {
        String fileName = FileUtils.changeExtension(null, "xml");
        assertNull(null, fileName);
        fileName = FileUtils.changeExtension("", "xml");
        assertEquals("", fileName);
    }
}