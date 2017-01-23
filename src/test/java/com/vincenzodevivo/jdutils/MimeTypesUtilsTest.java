package com.vincenzodevivo.jdutils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vincenzo De Vivo on 19/01/2017.
 */
public class MimeTypesUtilsTest {
    private static final Logger logger = LoggerFactory.getLogger(MimeTypesUtilsTest.class);

    @Test
    public void testGetFileContentType_pdf() throws Exception {
        String contentType = MimeTypesUtils.getFileContentType("C:\\test\\testFile.pdf");
        logger.debug(contentType);
        assertEquals("Content type mismatch", "application/pdf", contentType);
    }

    @Test
    public void testGetFileContentType_txt() throws Exception {
        String contentType = MimeTypesUtils.getFileContentType("testFile.txt");
        logger.debug(contentType);
        assertEquals("Content type mismatch", "text/plain", contentType);
    }

    @Test
    public void testGetFileContentType_PDF() throws Exception {
        String contentType = MimeTypesUtils.getFileContentType("TESTFILE.PDF");
        logger.debug(contentType);
        assertEquals("Content type mismatch", "application/pdf", contentType);
    }
}