package com.example.lenovo.app;

public class URL {
    private String http;
    private String login;
    private String regis;

    public URL(){
        http = "http://192.168.44.215:3000/";
        login = "application";
        regis = "regis";
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
}
