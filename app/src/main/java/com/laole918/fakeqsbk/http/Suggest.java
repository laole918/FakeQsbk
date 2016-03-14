package com.laole918.fakeqsbk.http;
import com.laole918.fakeqsbk.api.QsbkApi;
import com.laole918.fakeqsbk.event.QiushiEvent;
import com.laole918.fakeqsbk.model.Article;
import com.laole918.fakeqsbk.model.ArticleResponse;
import com.laole918.fakeqsbk.utils.EventBusUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastjsonConverterFactory;

/**
 * Created by laole918 on 2016/1/3.
 */
public class Suggest implements HttpApi {

    public static void get(int page, int count) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .addConverterFactory(FastjsonConverterFactory.create())
                .build();
        QsbkApi qsbkApi = retrofit.create(QsbkApi.class);
        Call<ArticleResponse> call = qsbkApi.getSuggest(page, count);

        call.enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                QiushiEvent.SuggestEvent event = new QiushiEvent.SuggestEvent();
                ArticleResponse ar = response.body();
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
            public void onFailure(Call<ArticleResponse> call, Throwable t) {
                QiushiEvent.SuggestEvent event = new QiushiEvent.SuggestEvent();
                event.setErrorMsg(t.getMessage());
                EventBusUtils.post(event);
            }
        });
    }
}
