package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.Locale;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {

        if (f.isDirectory() || getFileExtension(f).equals(".html")
                || getFileExtension(f).equals(".htm")) {
            return true;
        } else {
            return false;
        }
    }

    private String getFileExtension(File file) {
        String name = file.getName().toLowerCase(Locale.ROOT);
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf);
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
