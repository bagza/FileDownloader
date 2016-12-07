package com.liulishuo.filedownloader.file;

import android.os.Build;
import android.os.StatFs;

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

    @Override
    public long getFreeSpace() {
        long freeSpaceBytes;
        final StatFs statFs = new StatFs(file.getPath());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            freeSpaceBytes = statFs.getAvailableBytes();
        } else {
            //noinspection deprecation
            freeSpaceBytes = statFs.getAvailableBlocks() * (long) statFs.getBlockSize();
        }

        return freeSpaceBytes;
    }
}
