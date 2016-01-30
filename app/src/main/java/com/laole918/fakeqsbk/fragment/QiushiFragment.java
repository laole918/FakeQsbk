package com.laole918.fakeqsbk.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.AbsListView;

import com.camnter.easyslidingtabs.widget.EasySlidingTabs;
import com.laole918.fakeqsbk.R;
import com.laole918.fakeqsbk.adapter.TabsFragmentAdapter;
import com.laole918.fakeqsbk.fragment.qiuyoucircle.DayFragment_;
import com.laole918.fakeqsbk.fragment.qiuyoucircle.ImgrankFragment_;
import com.laole918.fakeqsbk.fragment.qiuyoucircle.SuggestFragment_;
import com.laole918.fakeqsbk.fragment.qiuyoucircle.TextFragment_;
import com.laole918.fakeqsbk.fragment.qiuyoucircle.VideoFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringArrayRes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laole918 on 2016/1/23.
 */
@EFragment(R.layout.fragment_qiushi)
public class QiushiFragment extends Fragment implements AbsListView.OnScrollListener {

    @ViewById
    ViewPager pager;
    @ViewById
    EasySlidingTabs tabs;

    @StringArrayRes
    String[] qiushi_menu;

    @AfterViews
    protected void afterViews() {
        List<Fragment> fs = new ArrayList<>();
        fs.add(SuggestFragment_.builder().build());
        fs.add(VideoFragment_.builder().build());
        fs.add(TextFragment_.builder().build());
        fs.add(ImgrankFragment_.builder().build());
        fs.add(DayFragment_.builder().build());
        pager.setAdapter(new TabsFragmentAdapter(getFragmentManager(), qiushi_menu, fs));
        tabs.setViewPager(pager);
        tabs.setUnderlinePadding0();
        int easyUnderlineHeight = (int) getResources().getDimension(R.dimen.easyUnderlineHeight);
        tabs.setUnderlineHeight(easyUnderlineHeight);
        int easyIndicatorHeight = (int) getResources().getDimension(R.dimen.easyIndicatorHeight);
        tabs.setIndicatorHeight(easyIndicatorHeight);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}

