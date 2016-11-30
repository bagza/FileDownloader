package com.liulishuo.filedownloader.file;

import android.content.Context;
import android.support.v4.provider.DocumentFile;

/**
 * Created by Zver on 29.11.2016.
 */

public class DocumentFileWrapper implements FileWrapper {

    private final Context context;
    private final DocumentFile documentFile;

    public DocumentFileWrapper(Context context, DocumentFile documentFile) {
        this.context = context;
        this.documentFile = documentFile;
    }

    @Override
    public boolean exists() {
        return false;
    }
}
