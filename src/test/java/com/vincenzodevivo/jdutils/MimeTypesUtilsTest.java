package com.vincenzodevivo.jdutils;

import junit.framework.TestCase;

/**
 * Created by Vincenzo De Vivo on 19/01/2017.
 */
public class MimeTypesUtilsTest extends TestCase {
    public void testGetFileContentType_pdf() throws Exception {
        String contentType = MimeTypesUtils.getFileContentType("C:\\test\\testFile.pdf");
        assertEquals("Content type mismatch", "application/pdf", contentType);
    }

    public void testGetFileContentType_txt() throws Exception {
        String contentType = MimeTypesUtils.getFileContentType("testFile.txt");
        assertEquals("Content type mismatch", "text/plain", contentType);
    }

    public void testGetFileContentType_PDF() throws Exception {
        String contentType = MimeTypesUtils.getFileContentType("TESTFILE.PDF");
        assertEquals("Content type mismatch", "application/pdf", contentType);
    }
}