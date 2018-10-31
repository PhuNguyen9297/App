package com.example.lenovo.app.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.lenovo.app.Control.Event;
import com.example.lenovo.app.Control.FeedAdapter;
import com.example.lenovo.app.R;
import com.example.lenovo.app.model.FeedContent;
import com.example.lenovo.app.model.URL;
import com.example.lenovo.app.model.VolleyRequest;
import com.example.lenovo.app.model.testing;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewFeed extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView.Adapter adapter;
    private Context context;
    private List<FeedContent> list;
    private Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_feed);

        context = getApplicationContext();
        event = new Event();

        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();

        event.loadContent(list, context);

        adapter = new FeedAdapter(getApplicationContext(), list);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }

}