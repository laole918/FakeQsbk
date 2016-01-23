package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;

import java.io.UnsupportedEncodingException;

/**
 * Created by laole918 on 2016/1/2.
 */
public class JsonStringRequest extends JsonRequest<String> {

    public JsonStringRequest(int method, String url, String jsonRequest,
                             Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener,
                errorListener);
    }

    public JsonStringRequest(String url, String jsonRequest, Response.Listener<String> listener,
                             Response.ErrorListener errorListener) {
        this(jsonRequest == null ? Method.GET : Method.POST, url, jsonRequest,
                listener, errorListener);
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String jsonString;
        try {
            jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));
        } catch (UnsupportedEncodingException e) {
            jsonString = new String(response.data);
        }
        return Response.success(jsonString, HttpHeaderParser.parseCacheHeaders(response));
    }
}
