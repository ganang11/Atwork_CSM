package com.example.app.atworkcsm.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Mu'adz on 3/21/2018.
 */

public class SessionManager {

    private SharedPreferences prefs;

    String hostIp, hostPort;

    public SessionManager(Context cntx) {
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void removeSession() {
        prefs.edit().remove("user").apply();
        prefs.edit().remove("code").apply();
    }

    public void setUser(String user){
        prefs.edit().putString("user", user).apply();
    }

    public String getUser(){
        String user = prefs.getString("user","");
        return user;
    }

    public void setCode(String code){
        prefs.edit().putString("code", code).apply();
    }

    public String getCode(){
        String code = prefs.getString("code","");
        return code;
    }
}
