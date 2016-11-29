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
}
