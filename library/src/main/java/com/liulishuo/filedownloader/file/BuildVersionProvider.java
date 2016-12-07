package com.liulishuo.filedownloader.file;

import android.os.Build;

/**
 * Created by bag on 01.12.16.
 *
 * Helper to mock that STATIC FINAL
 */
public class BuildVersionProvider {
    public int getVersion(){
        return Build.VERSION.SDK_INT;
    }
    public boolean is21orLater(){
        return getVersion() >= Build.VERSION_CODES.LOLLIPOP;
    }
}
