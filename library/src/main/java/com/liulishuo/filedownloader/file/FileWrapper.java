package com.liulishuo.filedownloader.file;

/**
 * Created by Zver on 29.11.2016.
 */

public interface FileWrapper  {
    boolean exists();

    final class Factory{
        public static FileWrapper bakeFileWrapper(String pathOrUri){

        }
    }
}
