package com.laole918.fakeqsbk.utils;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonStringListener;
import com.android.volley.toolbox.JsonStringRequest;
import com.android.volley.toolbox.Volley;

import in.srain.cube.util.CLog;

/**
 * Created by laole918 on 2016/1/2.
 */
public class VolleyUtils {

    private static final int TIME_OUT = 30 * 1000;//半分钟。

    private static final DefaultRetryPolicy mRetryPolicy = new DefaultRetryPolicy(
            TIME_OUT, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

    // 网络相关
    private static RequestQueue mQueue;

    public static void init(Context context) {
        mQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static <T> void add(Request<T> request) {
        request.setRetryPolicy(mRetryPolicy);
        mQueue.add(request);
    }

    public static void send(String url, String jsonRequest, JsonStringListener listener) {
        CLog.d("url", String.valueOf(url));
        CLog.d("jsonRequest", String.valueOf(jsonRequest));
        JsonStringRequest request = new JsonStringRequest(url, jsonRequest, listener, listener);
        add(request);
    }

    public static void send(String url, JsonStringListener listener) {
        CLog.d("url", String.valueOf(url));
        JsonStringRequest request = new JsonStringRequest(url, null, listener, listener);
        add(request);
    }

}
