package com.laole918.fakeqsbk.utils;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import com.laole918.fakeqsbk.MainApplication;

/**
 * Created by laole918 on 2016/1/30.
 */
public class DeviceUtils {

    private static String androidId = null;

    public static String getAndroidId()
    {
        if (androidId != null) {
            return androidId;
        }
        TelephonyManager telephonyManager = (TelephonyManager) MainApplication.App.getSystemService(Context.TELEPHONY_SERVICE);
        String temp = "\"DEVICEID\":\"" + telephonyManager.getDeviceId() + "\"-" + "\"ANDROID_ID\":\"" + Settings.Secure.getString(MainApplication.App.getContentResolver(), "android_id") + "\"";
        androidId = "IMEI_" + MD5Utils.MD5(temp);
        return androidId;
    }
}
