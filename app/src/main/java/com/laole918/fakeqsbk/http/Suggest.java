package com.laole918.fakeqsbk.http;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonStringListener;
import com.laole918.fakeqsbk.event.QiushiEvent;
import com.laole918.fakeqsbk.model.Article;
import com.laole918.fakeqsbk.model.ArticleResponse;
import com.laole918.fakeqsbk.utils.EventBusUtils;
import com.laole918.fakeqsbk.utils.JSONUtils;
import com.laole918.fakeqsbk.utils.VolleyUtils;

import java.util.List;

/**
 * Created by laole918 on 2016/1/3.
 */
public class Suggest implements HttpApi {

    public static void get(int page, int count) {
        String url = suggest + "?" + "page=" + page + "&count=" + count;
        VolleyUtils.send(url, listener);
    }

    private static JsonStringListener listener = new JsonStringListener() {
        @Override
        public void onResponse(String jsonString) {
            QiushiEvent.SuggestEvent event = new QiushiEvent.SuggestEvent();
            ArticleResponse ar = JSONUtils.parseObject(jsonString, ArticleResponse.class);
            if (ar != null) {
                if (ar.getErr() == 0) {
                    List<Article> as = ar.getItems();
                    event.setAs(as);
                }
            }
            if(event.isError()) {
                event.setErrorMsg("error");
            }
            EventBusUtils.post(event);
        }

        @Override
        public void onErrorResponse(VolleyError error) {
            QiushiEvent.SuggestEvent event = new QiushiEvent.SuggestEvent();
            event.setErrorMsg(error.getMessage());
            EventBusUtils.post(event);
        }
    };
}
