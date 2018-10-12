package com.example.lenovo.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.lenovo.app.R;
import com.example.lenovo.app.model.URL;
import com.example.lenovo.app.model.VolleyRequest;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    private EditText edtUser, edtGmail, edtPass;
    private Button btnRegis;
    private URL url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtGmail = findViewById(R.id.edtGmail);
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnRegis = findViewById(R.id.btnRegis);

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registration();
            }
        });
    }

    private void registration(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url.getHttp() + url.getRegis(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Thong tin sai!\nNhap lai",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String,String>();
                params.put("username",edtUser.getText().toString());
                params.put("email",edtGmail.getText().toString());
                params.put("password",edtPass.getText().toString());
                return params;
            }
        };
        VolleyRequest.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }
}