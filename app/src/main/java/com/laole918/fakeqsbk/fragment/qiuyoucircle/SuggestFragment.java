package com.laole918.fakeqsbk.fragment.qiuyoucircle;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;

import com.laole918.fakeqsbk.R;
import com.laole918.fakeqsbk.adapter.ArticleAdapter;
import com.laole918.fakeqsbk.event.QiushiEvent;
import com.laole918.fakeqsbk.http.Suggest;
import com.laole918.fakeqsbk.model.Article;
import com.laole918.fakeqsbk.utils.EventBusUtils;

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
public class SuggestFragment extends Fragment implements PtrHandler, LoadMoreHandler {

    @ViewById
    PtrClassicFrameLayout mPtrFrame;
    @ViewById
    LoadMoreListViewContainer moreContainer;
    @ViewById
    ListView listView;

    @Bean
    ArticleAdapter adapter;

    private boolean isDropDown;
    private int count = 30;
    private int page = 1;

    @AfterViews
    protected void afterViews() {
        EventBusUtils.register(this);
        mPtrFrame.setPtrHandler(this);
        mPtrFrame.setLastUpdateTimeRelateObject(this);
        moreContainer.setLoadMoreHandler(this);
        moreContainer.useDefaultFooter();

        listView.setAdapter(adapter);

        mPtrFrame.autoRefresh(true);
    }

    public void onDestroy() {
        super.onDestroy();
        EventBusUtils.unregister(this);
    }

    @Override
    public void onLoadMore(LoadMoreContainer loadMoreContainer) {
        isDropDown = false;
        page ++;
        Suggest.get(page, count);
    }

    @Override
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        return PtrDefaultHandler.checkContentCanBePulledDown(frame, listView, header);
    }

    @Override
    public void onRefreshBegin(PtrFrameLayout frame) {
        isDropDown = true;
        page = 1;
        Suggest.get(page, count);
    }

    public void onEvent(QiushiEvent.SuggestEvent event) {
        if(event.isError()) {
            if(isDropDown) {
                mPtrFrame.refreshComplete();
            } else {
                page --;
                moreContainer.loadMoreError(0, event.getErrorMsg());
            }
            return;
        }
        List<Article> as = event.getAs();
        boolean emptyResult = false;
        if(isDropDown) {
            emptyResult = as.isEmpty();
            adapter.clear();
            mPtrFrame.refreshComplete();
        }
        boolean hasMore = as.size() >= count;
        moreContainer.loadMoreFinish(emptyResult, hasMore);
        adapter.addAll(as);
        adapter.notifyDataSetChanged();
    }

}
