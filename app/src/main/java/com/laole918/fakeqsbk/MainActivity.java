package com.laole918.fakeqsbk;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.laole918.fakeqsbk.activity.HomeActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@Fullscreen
@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    View content_container;

    @AfterViews
    protected void afterViews() {
        content_container.setVisibility(View.INVISIBLE);
        showAd();
    }

    @UiThread(delay = 2000)
    protected void showAd() {
        content_container.setVisibility(View.VISIBLE);
        startApp();
    }

    @UiThread(delay = 1000)
    protected void startApp() {
        HomeActivity_.intent(this).start();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}
