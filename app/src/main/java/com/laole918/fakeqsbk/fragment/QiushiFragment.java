package com.laole918.fakeqsbk.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.camnter.easyslidingtabs.widget.EasySlidingTabs;
import com.laole918.fakeqsbk.R;
import com.laole918.fakeqsbk.adapter.TabsFragmentAdapter;

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
public class QiushiFragment extends Fragment {

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
        fs.add(SuggestFragment_.builder().build());
        fs.add(SuggestFragment_.builder().build());
        fs.add(SuggestFragment_.builder().build());
        fs.add(SuggestFragment_.builder().build());
        pager.setAdapter(new TabsFragmentAdapter(getFragmentManager(), qiushi_menu, fs));
        tabs.setViewPager(pager);
        tabs.setUnderlinePadding0();
        int easyUnderlineHeight = (int) getResources().getDimension(R.dimen.easyUnderlineHeight);
        tabs.setUnderlineHeight(easyUnderlineHeight);
        int easyIndicatorHeight = (int) getResources().getDimension(R.dimen.easyIndicatorHeight);
        tabs.setIndicatorHeight(easyIndicatorHeight);
    }
}

