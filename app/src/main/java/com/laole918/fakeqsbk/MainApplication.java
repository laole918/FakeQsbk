package com.laole918.fakeqsbk;

import android.app.Application;

import com.laole918.fakeqsbk.utils.ImageLoaderUtils;
import com.laole918.fakeqsbk.utils.VolleyUtils;

import org.androidannotations.annotations.EApplication;

/**
 * Created by laole918 on 2016/1/18.
 */
@EApplication
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        VolleyUtils.init(this);
        ImageLoaderUtils.init(this);
    }

}
