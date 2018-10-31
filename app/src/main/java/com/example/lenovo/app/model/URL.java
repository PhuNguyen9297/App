package com.example.lenovo.app.model;

public class URL {
    private String http;
    private String login;
    private String regis;
    private String getEvent, postEvent;

    public URL(){
        http = "http://192.168.44.215:3000/";
        login = "application";
        regis = "regis";
        getEvent = "";
        postEvent = "";
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

    public String getGetEvent() {
        return getEvent;
    }

    public String getPostEvent(){
        return postEvent;
    }
}
