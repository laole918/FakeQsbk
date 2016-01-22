package com.laole918.fakeqsbk.activity;

import android.support.v7.app.ActionBar;

import com.laole918.fakeqsbk.R;
import com.laole918.fakeqsbk.activity.base.BaseActivity;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * Created by laole918 on 2016/1/18.
 */
@EActivity(R.layout.activity_home)
public class HomeActivity extends BaseActivity {

    @AfterViews
    protected void afterViews() {
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setNavigationBarTintEnabled(true);
        tintManager.setStatusBarTintResource(R.color.colorStatusBar);
        tintManager.setNavigationBarTintResource(R.color.colorNavigationBar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_ab_qiushi);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

}
