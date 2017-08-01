package com.bncggle.easyutil.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.bncggle.easyutil.E;
import com.bncggle.easyutil.bean.VersionInfo;

/**
 * Created by xw on 2017/7/27.
 */

public class Util {

    /**
     * 返回当前的版本
     *
     * @return
     */
    public static VersionInfo getVersion() {
        Context context = E.getContext();
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
            int versionCode = packageInfo.versionCode;
            String versionName = packageInfo.versionName;
            return new VersionInfo(versionCode, versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}