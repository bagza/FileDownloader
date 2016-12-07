package com.liulishuo.filedownloader.file;

import android.content.Context;
import android.net.Uri;
import android.support.v4.provider.DocumentFile;

import java.io.File;

/**
 * Created by Zver on 29.11.2016.
 */

public interface FileWrapper  {
    boolean isDirectory();
    long length();
    boolean delete();
    boolean exists();
    long getFreeSpace();

    //TODO
    //BAKE FileDownloadOutputStream

    //For 19-20  just return LONG MAX... For a while. FROM UTILS
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

    //TODO
    /*private void todo() {
        //from DownloadTaskHunter
        //TODO MOVE PREPARE TO FACTORY
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


    }*/


    final class Factory{
        private final Context context;
        private final BuildVersionProvider buildVersionProvider;

        public Factory(Context context, BuildVersionProvider buildVersionProvider) {
            this.context = context;
            this.buildVersionProvider = buildVersionProvider;
        }

        public FileWrapper bakeFileWrapper(String pathOrUri){
            boolean isUriString = isUri(pathOrUri);
            if (isUriString) {
                Uri uri = Uri.parse(pathOrUri);
                return bakeWrapperByUri(uri);
            }
            else {
                return bakeWrapperByFilePath(pathOrUri);
            }
        }

        //Just distinguish filepath and Uri, not validating regex
        private boolean isUri(String maybeUri){
            return maybeUri.matches("(.+):(.+)");
        }

        private JavaFileWrapper bakeWrapperByFilePath(String path){
            return new JavaFileWrapper(new File(path));
        }

        private DocumentFileWrapper bakeWrapperByUri(Uri uri){
            DocumentFile documentFile = DocumentFile.fromSingleUri(context, uri);
            return new DocumentFileWrapper(context, documentFile, buildVersionProvider);
        }
    }
}
