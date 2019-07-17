package com.hs.common.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;


import java.util.List;

/**
 * 操作与系统相关的操作
 */
public class SystemUtils {

    /**
     * 根据包名判断是否安装了指定app
     *
     * @param context     上下文
     * @param app_package 包名
     * @return true-安装，flase-未安装
     */
    public static boolean isInstallApp(Context context, String app_package) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pInfo = packageManager.getInstalledPackages(0);
        if (pInfo != null) {
            for (int i = 0; i < pInfo.size(); i++) {
                String pn = pInfo.get(i).packageName;
                if (app_package.equals(pn)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 获取已经安装了的app列表（不包括系统应用）
     */
    public static String getAppList(Context context) {
        String str = "";
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pInfos = packageManager.getInstalledPackages(0);
        for (PackageInfo info : pInfos) {

            if ((info.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {//过滤系统应用
                try {
                    String appName = info.applicationInfo.loadLabel(packageManager).toString();//获取app名字
                    if (appName.indexOf(".") == -1)
                        str += info.applicationInfo.loadLabel(packageManager).toString().replace(" ", "") + "|";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    }

    /**
     * 复制到剪贴板
     *
     * @param context
     * @param info
     */
    public static void copyTextToBoard(Context context, String info) {
        ClipboardManager myClipboard = (ClipboardManager) context.getSystemService(context.CLIPBOARD_SERVICE);
        ClipData myClip = ClipData.newPlainText("text", info);
        myClipboard.setPrimaryClip(myClip);
        ToastUtils.showToast(context, "已复制到粘贴板");
    }

    /**
     * 打开拨号盘
     *
     * @param phone
     */
    public static void openCallPhone(Context context, String phone) {
        //Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));//直接拨号，需要权限
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));//打开拨号盘，不需要权限
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            copyTextToBoard(context, phone);
        }
    }

    /**
     * 打开QQ发起临时聊天，注意该QQ需要开通相关的功能
     *
     * @param qqNumber QQ号
     */
    public static void openQQ(Context context, String qqNumber) {
        String url = "mqqwpa://im/chat?chat_type=wpa&uin=" + qqNumber;
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        } catch (Exception e) {
            SystemUtils.copyTextToBoard(context, qqNumber);
        }
    }
}
