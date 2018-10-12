package com.example.lenovo.app.model;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyRequest {

    private static VolleyRequest instance;
    private Context context;
    private RequestQueue requestQueue;

    private VolleyRequest(Context context){
        this.context = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized VolleyRequest getInstance(Context context) {
        if (instance == null) {
            instance = new VolleyRequest(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}
