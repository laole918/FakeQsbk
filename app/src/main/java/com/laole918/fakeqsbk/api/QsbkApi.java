package com.laole918.fakeqsbk.api;

import com.laole918.fakeqsbk.model.ArticleResponse;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by laole918 on 2016/3/14 0014.
 */
public interface QsbkApi {

    @GET("/article/list/suggest")
    Observable<ArticleResponse> getSuggest(@Header("Uuid") String uuid, @Query("page") int page, @Query("count") int count);
}
