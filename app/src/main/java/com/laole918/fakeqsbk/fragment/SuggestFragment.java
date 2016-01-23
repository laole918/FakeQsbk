package com.laole918.fakeqsbk.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;

import com.laole918.fakeqsbk.R;
import com.laole918.fakeqsbk.adapter.ArticleAdapter;
import com.laole918.fakeqsbk.http.Suggest;
import com.laole918.fakeqsbk.model.Article;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import in.srain.cube.views.loadmore.LoadMoreContainer;
import in.srain.cube.views.loadmore.LoadMoreHandler;
import in.srain.cube.views.loadmore.LoadMoreListViewContainer;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by laole918 on 2016/1/20.
 */
@EFragment(R.layout.fragment_suggest)
public class SuggestFragment extends Fragment implements PtrHandler, LoadMoreHandler, Suggest.SuggestListener {

    @ViewById
    PtrClassicFrameLayout mPtrFrame;
    @ViewById
    LoadMoreListViewContainer moreContainer;
    @ViewById
    ListView listView;

    @Bean
    ArticleAdapter adapter;

    private Suggest suggest = new Suggest();

    @AfterViews
    protected void afterViews() {
        mPtrFrame.setPtrHandler(this);
        mPtrFrame.setLastUpdateTimeRelateObject(this);
        moreContainer.setLoadMoreHandler(this);
        moreContainer.useDefaultFooter();

        listView.setAdapter(adapter);
        suggest.setSuggestListener(this);

        mPtrFrame.autoRefresh(true);
    }

    @Override
    public void onLoadMore(LoadMoreContainer loadMoreContainer) {
        suggest.next();
    }

    @Override
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        return PtrDefaultHandler.checkContentCanBePulledDown(frame, listView, header);
    }

    @Override
    public void onRefreshBegin(PtrFrameLayout frame) {
        suggest.refresh();
    }

    @Override
    public void onSuccess(List<Article> as) {
        if(!suggest.isDropdown()) {
            adapter.clear();
            mPtrFrame.refreshComplete();
        }
        boolean emptyResult = as.isEmpty();
        boolean hasMore = suggest.hasNext();
        moreContainer.loadMoreFinish(emptyResult, hasMore);
        adapter.addAll(as);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {
        if(!suggest.isDropdown()) {
            mPtrFrame.refreshComplete();
        } else {
            moreContainer.loadMoreError(0, error);
        }
    }
}
