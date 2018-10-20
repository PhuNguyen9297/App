package com.example.lenovo.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
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
import java.util.List;

public class NewFeed extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView.Adapter adapter;
    private String link;
    private URL url;
    private List<FeedContent> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_feed);

        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();

        loadContent();

        adapter = new FeedAdapter(getApplicationContext(), list);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void loadContent(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url.getHttp() + url.getFeed(), new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i < response.length(); i++){
                    try{
                        JSONObject jsonObject = response.getJSONObject(i);

                        FeedContent feedContent = new FeedContent();
                        feedContent.setIdEvent(jsonObject.getInt("idEvent"));
                        feedContent.setName(jsonObject.getString("Name"));
                        feedContent.setIdPlace(jsonObject.getInt("idPlace"));
                        feedContent.setIdGroup(jsonObject.getInt("idGroup"));
                        feedContent.setIdUser(jsonObject.getInt("idUser"));
                        feedContent.setDownvote(jsonObject.getInt("Downvote"));
                        feedContent.setUpvote(jsonObject.getInt("Upvote"));
                        feedContent.setStart_Time(jsonObject.getString("Start_Time"));
                        feedContent.setEnd_Time(jsonObject.getString("End_Time"));
                        feedContent.setText(jsonObject.getString("Text"));
                        feedContent.setLink(jsonObject.getString("Link"));
                        feedContent.setPlace(jsonObject.getString("Place"));
                        feedContent.setImage(jsonObject.getString("Image"));

                        list.add(feedContent);

                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NewFeed.this, "Loi roi!", Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRequest.getInstance(getApplicationContext()).addToRequestQueue(jsonArrayRequest);
    }
}
