package com.example.lenovo.app.Control;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.lenovo.app.model.FeedContent;
import com.example.lenovo.app.model.URL;
import com.example.lenovo.app.model.VolleyRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class Event {
    private URL url = new URL();

    public void loadContent(final List<FeedContent> list, final Context context){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url.getHttp() + url.getGetEvent(), new Response.Listener<JSONArray>() {
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
                Toast.makeText(context, "Loi roi!", Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRequest.getInstance(context).addToRequestQueue(jsonArrayRequest);
    }

    public void upvote(){

    }

    public void downvote(){

    }

    public void invite(){

    }

    public void comment(){

    }
}
