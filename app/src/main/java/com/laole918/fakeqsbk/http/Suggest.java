package com.laole918.fakeqsbk.http;
import com.laole918.fakeqsbk.api.QsbkApi;
import com.laole918.fakeqsbk.event.QiushiEvent;
import com.laole918.fakeqsbk.model.Article;
import com.laole918.fakeqsbk.model.ArticleResponse;
import com.laole918.fakeqsbk.utils.EventBusUtils;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.fastjson.FastjsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by laole918 on 2016/1/3.
 */
public class Suggest implements HttpApi {

    public static void get(int page, int count) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(FastjsonConverterFactory.create())
                .build();
        QsbkApi qsbkApi = retrofit.create(QsbkApi.class);
        Observable<ArticleResponse> observable = qsbkApi.getSuggest(page, count);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(ar->{
            QiushiEvent.SuggestEvent event = new QiushiEvent.SuggestEvent();
            if (ar.getErr() == 0) {
                List<Article> as = ar.getItems();
                event.setAs(as);
            }
            if(event.isError()) {
                event.setErrorMsg("error");
            }
            EventBusUtils.post(event);
        }, e->{
            QiushiEvent.SuggestEvent event = new QiushiEvent.SuggestEvent();
            event.setErrorMsg(e.getMessage());
            EventBusUtils.post(event);
        });
    }
}
