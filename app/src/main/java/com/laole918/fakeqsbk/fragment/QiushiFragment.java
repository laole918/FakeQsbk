package com.laole918.fakeqsbk.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.TextUtils;

import com.camnter.easyslidingtabs.widget.EasySlidingTabs;
import com.laole918.fakeqsbk.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

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

    @AfterViews
    protected void afterViews() {
        List<Fragment> fs = new ArrayList<>();
        fs.add(SuggestFragment_.builder().build());
        fs.add(SuggestFragment_.builder().build());
        fs.add(SuggestFragment_.builder().build());
        fs.add(SuggestFragment_.builder().build());
        fs.add(SuggestFragment_.builder().build());
        String[] titles = new String[] {"专享", "视频", "纯文", "纯图", "精华"};
        pager.setAdapter(new TabsFragmentAdapter(getFragmentManager(), titles, fs));
        tabs.setViewPager(pager);
        tabs.setUnderlinePadding0();
    }

    public class TabsFragmentAdapter extends FragmentPagerAdapter implements EasySlidingTabs.TabsTitleInterface {

        private String[] titles;
        private List<Fragment> fragments;

        public TabsFragmentAdapter(FragmentManager fm, String[] titles, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
            this.titles = titles;
        }

        @Override
        public SpannableString getTabTitle(int position) {
            CharSequence title = this.getPageTitle(position);
            if (TextUtils.isEmpty(title)) return new SpannableString("");
            SpannableString spannableString = new SpannableString(title);
            return spannableString;
        }

        /**
         * This method may be called by the ViewPager to obtain a title string
         * to describe the specified page. This method may return null
         * indicating no title for this page. The default implementation returns
         * null.
         *
         * @param position The position of the title requested
         * @return A title for the requested page
         */
        @Override
        public CharSequence getPageTitle(int position) {
            if (position < titles.length) {
                return titles[position];
            } else {
                return "";
            }
        }

        /**
         * Return the Fragment associated with a specified position.
         *
         * @param position
         */
        @Override
        public Fragment getItem(int position) {
            Fragment fragment = this.fragments.get(position);
            if (fragment != null) {
                return this.fragments.get(position);
            } else {
                return null;
            }
        }

        @Override
        public int getTabDrawableBottom(int position) {
            return 0;
        }

        @Override
        public int getTabDrawableLeft(int position) {
            return 0;
        }

        @Override
        public int getTabDrawableRight(int position) {
            return 0;
        }

        @Override
        public int getTabDrawableTop(int position) {
            return 0;
        }


        /**
         * Return the number of views available.
         */
        @Override
        public int getCount() {
            return this.fragments.size();
        }

    }
}

