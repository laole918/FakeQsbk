package com.laole918.fakeqsbk.api;

import com.laole918.fakeqsbk.model.ArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by laole918 on 2016/3/14 0014.
 */
public interface QsbkApi {

    @GET("/article/list/suggest")
    Call<ArticleResponse> getSuggest(@Query("page") int page, @Query("count") int count);
}
