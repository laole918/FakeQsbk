package com.laole918.fakeqsbk;

import android.app.Application;

import com.laole918.fakeqsbk.utils.ImageLoaderUtils;

import org.androidannotations.annotations.EApplication;
import org.xutils.x;

/**
 * Created by laole918 on 2016/1/18.
 */
@EApplication
public class MainApplication extends Application {

    public static Application App;

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderUtils.init(this);
        x.Ext.init(this);
        x.Ext.setDebug(true); // 是否输出debug日志
        App = this;
    }

}
