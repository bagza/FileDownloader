package com.liulishuo.filedownloader.file;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.support.v4.provider.DocumentFile;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStatVfs;
import android.util.Log;

import java.io.FileNotFoundException;

/**
 * Created by Zver on 29.11.2016.
 */

public class DocumentFileWrapper implements FileWrapper {

    private final Context context;
    private final DocumentFile documentFile;
    private final BuildVersionProvider buildVersionProvider;

    public DocumentFileWrapper(Context context, DocumentFile documentFile, BuildVersionProvider buildVersionProvider) {
        this.context = context;
        this.documentFile = documentFile;
        this.buildVersionProvider = buildVersionProvider;
    }

    public DocumentFile getDocumentFile() {
        return documentFile;
    }

    @Override
    public boolean exists() {
        return documentFile.exists();
    }

    @Override
    public boolean isDirectory() {
        return documentFile.isDirectory();
    }

    @Override
    public long length() {
        return documentFile.length();
    }

    @Override
    public boolean delete() {
        return documentFile.delete();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public long getFreeSpace() {
        if (buildVersionProvider.is21orLater()) {
            try {
                ParcelFileDescriptor pfd = context.getContentResolver().openFileDescriptor(documentFile.getUri(), "r");
                assert pfd != null;
                StructStatVfs stats = Os.fstatvfs(pfd.getFileDescriptor());
                return stats.f_bavail * stats.f_bsize;
                /*Log.i(LOG_TAG, "block_size=" + stats.f_bsize + ", num_of_blocks=" + stats.f_bavail);
                Log.i(LOG_TAG, "free space in Megabytes:" + stats.f_bavail * stats.f_bsize / 1024 / 1024);*/
            } catch (FileNotFoundException | ErrnoException e) {
                Log.e("DocumentFile Error", Log.getStackTraceString(e));
            }
        }

        return Long.MAX_VALUE;
    }
}
