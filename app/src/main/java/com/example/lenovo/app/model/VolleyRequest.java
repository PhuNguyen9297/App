package com.example.lenovo.app.model;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lenovo.app.activity.NewFeedTest;

import java.util.HashMap;
import java.util.Map;

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

    public StringRequest login(final Context context, final String gmailEdt, final String passwordEdt){
        String url = "http://192.168.1.2:3000/application";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, NewFeedTest.class);
                        context.startActivity(intent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"Thong tin sai!\nNhap lai",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String,String>();
                params.put("username",gmailEdt);
                params.put("password",passwordEdt);

                return params;
            }
        };
        return stringRequest;
    }
}
