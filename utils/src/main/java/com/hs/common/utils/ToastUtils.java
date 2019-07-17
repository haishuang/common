package com.hs.common.utils;

import android.content.Context;
import android.widget.Toast;

import com.hs.common.view.ShowActionDialog;


public class ToastUtils {

    //自定义的
    public static void showToast(Context context, String msg) {
        ShowActionDialog showActionDialog = new ShowActionDialog(context);
        showActionDialog.show();
        showActionDialog.setActionText(msg);
        showActionDialog.setCancelable(false);
    }

    /**
     * 长时间Toast
     * @param context
     * @param msg
     */
    public static void showLongToast(Context context, String msg) {
        showToast(context, msg, Toast.LENGTH_LONG);
    }

    /**
     * 短时间Toast
     * @param context
     * @param msg
     */
    public static void showShortToast(Context context, String msg) {
        showToast(context, msg, Toast.LENGTH_SHORT);
    }

    private static void showToast(Context context,String msg,int duration ){
        Toast.makeText(context, msg, duration).show();
    }
}
