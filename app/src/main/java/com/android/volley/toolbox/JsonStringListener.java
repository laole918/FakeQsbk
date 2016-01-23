package com.android.volley.toolbox;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public interface JsonStringListener extends Response.ErrorListener, Response.Listener<String> {

	@Override
	public void onResponse(String jsonString);

	@Override
	public void onErrorResponse(VolleyError error);

}
