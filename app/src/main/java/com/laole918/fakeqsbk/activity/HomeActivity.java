package com.laole918.fakeqsbk.activity;

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
    }
}
