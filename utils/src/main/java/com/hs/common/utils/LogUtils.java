package com.hs.common.utils;

import android.util.Log;

public class LogUtils {
    public static final String TAG = "LogUtils";

    public static void v(String msg) {
        v(TAG, msg);
    }

    public static void v(String tag, String msg) {
        Log.v(tag, msg);
    }

    public static void e(String msg) {
        e(TAG, msg);
    }

    public static void e(String tag, String msg) {
        Log.v(tag, msg);
    }
}
