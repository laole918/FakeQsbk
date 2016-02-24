package com.laole918.fakeqsbk.http;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;
import org.xutils.http.app.DefaultParamsBuilder;

/**
 * Created by laole918 on 2016/2/24.
 */
@HttpRequest(
        host = "http://m2.qiushibaike.com",
        path = "article/list",
        builder = DefaultParamsBuilder.class/*可选参数, 控制参数构建过程, 定义参数签名, SSL证书等*/)
public class ArticleParams extends RequestParams {

}
