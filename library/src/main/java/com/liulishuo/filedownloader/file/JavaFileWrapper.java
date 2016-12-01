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
        return false;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public long length() {
        return 0;
    }

    @Override
    public boolean delete() {
        return false;
    }
}
