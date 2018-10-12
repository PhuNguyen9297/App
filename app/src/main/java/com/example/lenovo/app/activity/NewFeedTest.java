package com.example.lenovo.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.lenovo.app.FeedAdapter;
import com.example.lenovo.app.R;
import com.example.lenovo.app.model.VolleyRequest;
import com.example.lenovo.app.testing;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewFeedTest extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<testing> list;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_feed_test);

        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();

        loadContent();
        adapter = new FeedAdapter(getApplicationContext(), list);

        linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void loadContent(){
        String url = "https://jsonplaceholder.typicode.com/posts";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i < response.length(); i++){
                    try{
                        JSONObject jsonObject = response.getJSONObject(i);

                        testing test = new testing();
                        test.setUserId(jsonObject.getInt("userId"));
                        test.setId(jsonObject.getInt("id"));
                        test.setTitle(jsonObject.getString("title"));
                        test.setBody(jsonObject.getString("body"));

                        list.add(test);

                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NewFeedTest.this, "Loi roi!", Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRequest.getInstance(getApplicationContext()).addToRequestQueue(jsonArrayRequest);
    }
}