package com.vincenzodevivo.jdutils.file;

import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Vincenzo De Vivo on 15/02/2017.
 */
public class FlatFileListTest {
    @Test
    public void addFile() throws Exception {
        FlatFileList fileList = new FlatFileList("java");
        fileList.addFile(new File("."));
        List<File> list = fileList.getList();
        assertTrue("list.size() < 0", list.size() > 0);
        for (File file : list) {
            System.out.println(file);
        }
    }
    @Test
    public void addFiles() throws Exception {
        List<File> list = FileUtils.flatFileList(new File(".").listFiles());
        assertTrue("list.size() < 0", list.size() > 0);
        for (File file : list) {
            System.out.println(file);
        }
    }
}