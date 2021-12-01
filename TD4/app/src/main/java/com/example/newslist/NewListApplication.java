package com.example.newslist;

import android.app.Application;
public class NewListApplication extends Application{

    String login;
    @Override
    public void onCreate() {
        super.onCreate();
        this.login = null;
    }
    public String getLog() {
        return login;
    }
    public void setLog(String log) {
        this.login = log;
    }

}
