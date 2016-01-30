package com.laole918.fakeqsbk.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Toast;

import com.laole918.fakeqsbk.R;
import com.laole918.fakeqsbk.activity.base.BaseActivity;
import com.laole918.fakeqsbk.fragment.MessageFragment_;
import com.laole918.fakeqsbk.fragment.MineFragment_;
import com.laole918.fakeqsbk.fragment.NearbyFragment_;
import com.laole918.fakeqsbk.fragment.QiushiFragment_;
import com.laole918.fakeqsbk.fragment.QiuyouCircleFragment_;
import com.laole918.fakeqsbk.utils.ToastUtils;
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

    private final String qiushi = "qiushi";
    private final String qiuyoucircle = "qiuyoucircle";
    private final String nearby = "nearby";
    private final String message = "message";
    private final String mine = "mine";

    private Fragment qiushiFragment, qiuyoucircleFragment, nearbyFragment, messageFragment, mineFragment;

    @ViewById
    View btn_ic_qiushi, btn_ic_qiuyoucircle, btn_ic_nearby, btn_ic_message, btn_ic_mine;

    private long lastBackPressedTimeMillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            qiushiFragment = getSupportFragmentManager().findFragmentByTag(qiushi);
            qiuyoucircleFragment = getSupportFragmentManager().findFragmentByTag(qiuyoucircle);
            nearbyFragment = getSupportFragmentManager().findFragmentByTag(nearby);
            messageFragment = getSupportFragmentManager().findFragmentByTag(message);
            mineFragment = getSupportFragmentManager().findFragmentByTag(mine);
        }
        lastBackPressedTimeMillis = System.currentTimeMillis();
    }

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

        setTabSelection(qiushi);
    }

    public void onBackPressed() {
        long nowTimeMillis = System.currentTimeMillis();
        //在一秒内再次按下返回键退出应用
        if(nowTimeMillis - lastBackPressedTimeMillis > 1000) {
            lastBackPressedTimeMillis = nowTimeMillis;
            ToastUtils.show(this, R.string.tip_back_pressed, Toast.LENGTH_SHORT);
            return;
        }
        super.onBackPressed();
    }

    @Click(R.id.btn_ic_qiushi)
    protected void onClickQiushi() {
        if(!btn_ic_qiushi.isSelected()) {
            setTabSelection(qiushi);
        }
    }

    @Click(R.id.btn_ic_qiuyoucircle)
    protected void onClickQiuyouCircle() {
        if(!btn_ic_qiuyoucircle.isSelected()) {
            setTabSelection(qiuyoucircle);
        }
    }

    @Click(R.id.btn_ic_nearby)
    protected void onClickNearby() {
        if(!btn_ic_nearby.isSelected()) {
            setTabSelection(nearby);
        }
    }

    @Click(R.id.btn_ic_message)
    protected void onClickMessage() {
        if(!btn_ic_message.isSelected()) {
            setTabSelection(message);
        }
    }

    @Click(R.id.btn_ic_mine)
    protected void onClickMine() {
        if(!btn_ic_mine.isSelected()) {
            setTabSelection(mine);
        }
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param tab
     *            每个tab页对应的下标。0糗事，1糗友圈，2发现，3小纸条，4我的。
     */
    private void setTabSelection(String tab) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (tab) {
            case qiushi: {
                btn_ic_qiushi.setSelected(true);
                if (qiushiFragment == null) {
                    qiushiFragment = QiushiFragment_.builder().build();
                    transaction.add(R.id.home_content, qiushiFragment, qiushi);
                } else {
                    transaction.show(qiushiFragment);
                }
                break;
            }
            case qiuyoucircle: {
                btn_ic_qiuyoucircle.setSelected(true);
                if (qiuyoucircleFragment == null) {
                    qiuyoucircleFragment = QiuyouCircleFragment_.builder().build();
                    transaction.add(R.id.home_content, qiuyoucircleFragment, qiuyoucircle);
                } else {
                    transaction.show(qiuyoucircleFragment);
                }
                break;
            }
            case nearby: {
                btn_ic_nearby.setSelected(true);
                if (nearbyFragment == null) {
                    nearbyFragment = NearbyFragment_.builder().build();
                    transaction.add(R.id.home_content, nearbyFragment, nearby);
                } else {
                    transaction.show(nearbyFragment);
                }
                break;
            }
            case message: {
                btn_ic_message.setSelected(true);
                if (messageFragment == null) {
                    messageFragment = MessageFragment_.builder().build();
                    transaction.add(R.id.home_content, messageFragment, message);
                } else {
                    transaction.show(messageFragment);
                }
                break;
            }
            case mine: {
                btn_ic_mine.setSelected(true);
                if (mineFragment == null) {
                    mineFragment = MineFragment_.builder().build();
                    transaction.add(R.id.home_content, mineFragment, mine);
                } else {
                    transaction.show(mineFragment);
                }
                break;
            }
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        btn_ic_qiushi.setSelected(false);
        btn_ic_qiuyoucircle.setSelected(false);
        btn_ic_nearby.setSelected(false);
        btn_ic_message.setSelected(false);
        btn_ic_mine.setSelected(false);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *            用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (qiushiFragment != null) {
            transaction.hide(qiushiFragment);
        }
        if (qiuyoucircleFragment != null) {
            transaction.hide(qiuyoucircleFragment);
        }
        if (nearbyFragment != null) {
            transaction.hide(nearbyFragment);
        }
        if (messageFragment != null) {
            transaction.hide(messageFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }

}
