package com.example.lenovo.app.model;

public class URL {
    private String http;
    private String login;
    private String regis;
    private String feed;

    public URL(){
        http = "http://192.168.44.215:3000/";
        login = "application";
        regis = "regis";
        feed = "";
    }

    public String getHttp() {
        return http;
    }

    public String getLogin() {
        return login;
    }

    public String getRegis() {
        return regis;
    }

    public String getFeed() {
        return feed;
    }
}
