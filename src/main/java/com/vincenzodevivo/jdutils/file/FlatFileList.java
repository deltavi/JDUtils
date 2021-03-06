package com.vincenzodevivo.jdutils.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincenzo De Vivo on 15/02/2017.
 */
public class FlatFileList {
    List<File> list = new ArrayList<>();
    private String extension;

    public FlatFileList(String extension) {
        this.extension = extension;
    }

    public FlatFileList() {
        this.extension = null;
    }

    public String getExtension() {
        return extension;
    }

    public List<File> getList() {
        return list;
    }

    public void addFile(File file) {
        if (file.isFile()) {
            if (extension == null || file.getName().toLowerCase().endsWith("." + extension.toLowerCase())) {
                list.add(file);
            }
        } else {
            File[] files = file.listFiles();
            for (File subFile : files) {
                addFile(subFile);
            }
        }
    }

    public void addFiles(File[] files) {
        for (File file : files) {
            addFile(file);
        }
    }

    public void addFiles(List<File> files) {
        for (File file : files) {
            addFile(file);
        }
    }
}
