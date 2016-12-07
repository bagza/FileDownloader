package com.liulishuo.filedownloader.stream;

import android.content.Context;
import android.support.v4.provider.DocumentFile;

import com.liulishuo.filedownloader.file.DocumentFileWrapper;
import com.liulishuo.filedownloader.file.FileWrapper;
import com.liulishuo.filedownloader.util.FileDownloadHelper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by bag on 07.12.16.
 */

public class FileDownloadDocumentFileStream implements FileDownloadOutputStream {

    private final DocumentFile documentFile;
    private final Context context;
    private final OutputStream outputStream;

    public FileDownloadDocumentFileStream(DocumentFile documentFile, Context context) throws FileNotFoundException {
        this.documentFile = documentFile;
        this.context = context;
        outputStream = context.getContentResolver().openOutputStream(documentFile.getUri(), "rw");
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        outputStream.write(b, off, len);
    }

    @Override
    public void sync() throws IOException {
        outputStream.flush();
    }

    @Override
    public void close() throws IOException {
        outputStream.close();
    }

    @Override
    public void seek(long offset) throws IOException, IllegalAccessException {
        throw new IllegalAccessException("Can't support 'seek' in DocumentFile.");
    }

    @Override
    public void setLength(long newLength) throws IOException, IllegalAccessException {
        throw new IllegalAccessException("Can't support 'setLength' in DocumentFile.");
    }

    public static class Creator implements FileDownloadHelper.OutputStreamCreator {

        @Override
        public FileDownloadOutputStream create(FileWrapper file) throws FileNotFoundException {
            assert file instanceof DocumentFileWrapper;
            return new FileDownloadDocumentFileStream(((DocumentFileWrapper) file).getDocumentFile(), FileDownloadHelper.getAppContext());
        }

        @Override
        public boolean supportSeek() {
            return false;
        }
    }
}
