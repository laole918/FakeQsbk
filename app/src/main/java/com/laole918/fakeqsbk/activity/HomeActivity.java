package com.laole918.fakeqsbk.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.FrameLayout;

import com.laole918.fakeqsbk.R;
import com.laole918.fakeqsbk.activity.base.BaseActivity;
import com.laole918.fakeqsbk.fragment.QiushiFragment;
import com.laole918.fakeqsbk.fragment.QiushiFragment_;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by laole918 on 2016/1/18.
 */
@EActivity(R.layout.activity_home)
public class HomeActivity extends BaseActivity {

    @ViewById
    FrameLayout home_content;

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

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.home_content, QiushiFragment_.builder().build());
        transaction.commit();
    }

    @Click(R.id.btn_ic_qiushi)
    protected void onClickQiushi(View v) {
        v.setSelected(true);
    }

    @Click(R.id.btn_ic_qiuyoucircle)
    protected void onClickQiuyouCircle(View v) {
        v.setSelected(true);
    }

    @Click(R.id.btn_ic_nearby)
    protected void onClickNearby(View v) {
        v.setSelected(true);
    }

    @Click(R.id.btn_ic_message)
    protected void onClickMessage(View v) {
        v.setSelected(true);
    }

    @Click(R.id.btn_ic_mine)
    protected void onClickMine(View v) {
        v.setSelected(true);
    }

}
