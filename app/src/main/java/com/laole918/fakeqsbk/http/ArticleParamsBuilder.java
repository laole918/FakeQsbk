package com.laole918.fakeqsbk.http;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;
import org.xutils.http.app.DefaultParamsBuilder;

/**
 * Created by laole918 on 2016/2/24.
 */
public class ArticleParamsBuilder extends DefaultParamsBuilder {
    @Override
    public String buildUri(RequestParams params, HttpRequest httpRequest) {
        return super.buildUri(params, httpRequest);
    }

    @Override
    public void buildParams(RequestParams params) {

    }

}
