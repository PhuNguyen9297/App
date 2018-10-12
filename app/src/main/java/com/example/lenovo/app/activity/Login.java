package com.example.lenovo.app.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.lenovo.app.R;
import com.example.lenovo.app.model.URL;
import com.example.lenovo.app.model.VolleyRequest;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    private RequestQueue requestQueue;
    private EditText gmailEdt;
    private EditText passwordEdt;
    private Button LoginBt;
    private TextView regisTv;
    private ProgressBar progressBar;
    private TextView skipTv;
    private VolleyRequest volleyRequest;
    private URL url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = VolleyRequest.getInstance(getApplicationContext()).getRequestQueue();
        requestQueue.start();

        gmailEdt = findViewById(R.id.gmailEdt);
        passwordEdt = (EditText)findViewById(R.id.passwordEdt);
        LoginBt = findViewById(R.id.LoginBt);
        progressBar = findViewById(R.id.progressbar);
        regisTv = findViewById(R.id.regisTv);
        skipTv = findViewById(R.id.skipTv);

        LoginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               login();
            }
        });

        regisTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regis();
            }
        });

        skipTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewFeedTest.class);
                startActivity(intent);
            }
        });
    }

    private void login(){
        progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url.getHttp() + url.getLogin(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //if(response == something ){}
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), NewFeedTest.class);
                        startActivity(intent);
                        progressBar.setVisibility(View.GONE);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Khong vao duoc server",Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String,String>();
                params.put("username",gmailEdt.getText().toString());
                params.put("password",passwordEdt.getText().toString());

                return params;
            }
        };
        VolleyRequest.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }

    private void regis(){
        Intent intent = new Intent(getApplicationContext(), Register.class);
        startActivity(intent);
    }
}
