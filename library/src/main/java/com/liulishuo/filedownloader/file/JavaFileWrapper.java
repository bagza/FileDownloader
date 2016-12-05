package com.liulishuo.filedownloader.file;

import java.io.File;

/**
 * Created by Zver on 29.11.2016.
 */

public class JavaFileWrapper implements FileWrapper{

    private final File file;

    public JavaFileWrapper(File file) {
        this.file = file;
    }

    @Override
    public boolean exists() {
        return file.exists();
    }

    @Override
    public boolean isDirectory() {
        return file.isDirectory();
    }

    @Override
    public long length() {
        return file.length();
    }

    @Override
    public boolean delete() {
        return file.delete();
    }
}
