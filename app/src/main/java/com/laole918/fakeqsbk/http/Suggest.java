package com.laole918.fakeqsbk.http;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonStringListener;
import com.laole918.fakeqsbk.model.Article;
import com.laole918.fakeqsbk.model.ArticleResponse;
import com.laole918.fakeqsbk.utils.JSONUtils;
import com.laole918.fakeqsbk.utils.VolleyUtils;

import java.util.List;

/**
 * Created by laole918 on 2016/1/3.
 */
public class Suggest extends Page implements HttpApi, JsonStringListener {

    private boolean isDropdown = false;
    private boolean hasNext = true;
    private SuggestListener listener;

    public void setSuggestListener(SuggestListener listener) {
        this.listener = listener;
    }

    public void refresh() {
        isDropdown = false;
        setPage(1);
        setCount(30);
        send();
    }

    public void send() {
        String url = suggest + "?" + "page=" + getPage() + "&count=" + getCount();
        VolleyUtils.send(url, this);
    }

    public boolean hasNext() {
        return hasNext;
    }

    public boolean isDropdown() {
        return isDropdown;
    }

    public void next() {
        isDropdown = true;
        nextPage();
        setCount(30);
        send();
    }

    @Override
    public void onResponse(String jsonString) {
        ArticleResponse ar = JSONUtils.parseObject(jsonString, ArticleResponse.class);
        if(ar != null) {
            if(ar.getErr() == 0) {
                List<Article> as = ar.getItems();
                hasNext = as.size() >= 30;
                mListener.onSuccess(as);
            } else {
                mListener.onError("未知错误");
            }
        } else {
            mListener.onError("未知错误");
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        mListener.onError(error.getMessage());
    }

    private SuggestListener mListener = new SuggestListener() {
        @Override
        public void onSuccess(List<Article> as) {
            if(listener != null) {
                listener.onSuccess(as);
            }
        }

        @Override
        public void onError(String error) {
            if(listener != null) {
                listener.onError(error);
            }
        }
    };

    public interface SuggestListener {
        void onSuccess(List<Article> as);
        void onError(String error);
    }
}
