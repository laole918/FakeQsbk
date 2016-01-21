package com.laole918.fakeqsbk.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;
import com.laole918.fakeqsbk.R;
import com.laole918.fakeqsbk.activity.base.BaseActivity;
import com.laole918.fakeqsbk.activity.fragment.SuggestFragment_;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by laole918 on 2016/1/18.
 */
@EActivity(R.layout.activity_home)
public class HomeActivity extends BaseActivity {

    @ViewById
    PagerSlidingTabStrip tabs;
    @ViewById
    ViewPager pager;

    @AfterViews
    protected void afterViews() {
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setNavigationBarTintEnabled(true);
        tintManager.setStatusBarTintResource(R.color.colorStatusBar);
        tintManager.setNavigationBarTintResource(R.color.colorNavigationBar);

        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabs.setViewPager(pager);
//        tabs.setTextColor();
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = { "专享", "视频", "纯的的的文", "纯图", "精华" };

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {
            return SuggestFragment_.builder().build();
        }

    }
}
