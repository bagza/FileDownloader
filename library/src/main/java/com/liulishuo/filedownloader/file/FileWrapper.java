package com.liulishuo.filedownloader.file;

import android.os.Build;
import android.os.StatFs;
import android.support.v4.provider.DocumentFile;

import com.liulishuo.filedownloader.util.FileDownloadUtils;

import java.io.File;
import java.security.InvalidParameterException;

/**
 * Created by Zver on 29.11.2016.
 */

public interface FileWrapper  {
    boolean isDirectory();
    long length();
    boolean delete();
    boolean exists();

    //TODO
    //BAKE FileDownloadOutputStream

    //For 19-20  just return LONG MAX... For a while.
    /*public static long getFreeSpaceBytes(final String path) {
        long freeSpaceBytes;
        final StatFs statFs = new StatFs(path);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            freeSpaceBytes = statFs.getAvailableBytes();
        } else {
            //noinspection deprecation
            freeSpaceBytes = statFs.getAvailableBlocks() * (long) statFs.getBlockSize();
        }

        return freeSpaceBytes;
    }*/

    /*//TODO
    private void todo() {


        //from DownloadTaskHunter
        //TODO MOVE TO FACTORY
        createDirectoriesIfNeeded{
            final File dir;
            if (origin.isPathAsDirectory()) {
                dir = new File(origin.getPath());
            } else {
                final String dirString = FileDownloadUtils.getParent(origin.getPath());
                if (dirString == null) {
                    throw new InvalidParameterException(
                            FileDownloadUtils.formatString("the provided mPath[%s] is invalid," +
                                    " can't find its directory", origin.getPath()));
                }
                dir = new File(dirString);
            }

            if (!dir.exists()) {
                //noinspection ResultOfMethodCallIgnored
                dir.mkdirs();
            }
        }

        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new IOException(
                        FileDownloadUtils.formatString("create new file error  %s",
                                file.getAbsolutePath()));
            }
        }



        boolean isDirectory();

        length()

        delete


    }


    final class Factory{
        public static FileWrapper bakeFileWrapper(String pathOrUri){

        }

        public static FileWrapper bakeFile(){

        }

        public static String getTempPathOrUri(String pathOrUri){
            //just return the same for URI
        }
    }*/
}
