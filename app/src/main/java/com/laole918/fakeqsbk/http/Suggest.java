package com.laole918.fakeqsbk.http;
import com.laole918.fakeqsbk.api.QsbkApi;
import com.laole918.fakeqsbk.event.QiushiEvent;
import com.laole918.fakeqsbk.model.Article;
import com.laole918.fakeqsbk.model.ArticleResponse;
import com.laole918.fakeqsbk.utils.DeviceUtils;
import com.laole918.fakeqsbk.utils.EventBusUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.fastjson.FastjsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func1;
import rx.functions.Func2;
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
        Observable<ArticleResponse> observable1 = qsbkApi.getSuggest(DeviceUtils.getAndroidId(), page, count);
        Observable<ArticleResponse> observable2 = qsbkApi.getSuggest(DeviceUtils.getAndroidId(), page, count);
//        Observable.zip(observable1, observable2, (r1, r2) -> {
//            return Observable.concat(r1, r2);
//        })
//        observable.subscribeOn(Schedulers.io()).map(ar->{
//            if(ar.getErr() == 0) {
//                return ar.getItems();
//            } else {
//                throw new RuntimeException();
//            }
//        }).observeOn(AndroidSchedulers.mainThread()).subscribe(as->{
//            QiushiEvent.SuggestEvent event = new QiushiEvent.SuggestEvent();
//            event.setAs(as);
//            if(event.isError()) {
//                event.setErrorMsg("error");
//            }
//            EventBusUtils.post(event);
//        }, e->{
//            QiushiEvent.SuggestEvent event = new QiushiEvent.SuggestEvent();
//            event.setErrorMsg(e.getMessage());
//            EventBusUtils.post(event);
//        });
    }
}
