package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.laole918.fakeqsbk.utils.DeviceUtils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

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

    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Uuid", DeviceUtils.getAndroidId());
        return headers;
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
