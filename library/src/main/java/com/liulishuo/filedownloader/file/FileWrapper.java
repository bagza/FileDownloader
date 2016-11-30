package com.liulishuo.filedownloader.file;

import com.liulishuo.filedownloader.util.FileDownloadUtils;

import java.io.File;
import java.security.InvalidParameterException;

/**
 * Created by Zver on 29.11.2016.
 */

public interface FileWrapper  {
    boolean exists();


    /*//TODO
    private void todo() {

        //usage of this?? on N make move document.
        FileDownloadUtils.getTempPath(getTargetFilePath());

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

        //delete temp files.


        //JUST for compatibility
        boolean renameTo()

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
