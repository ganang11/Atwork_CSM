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

    public void setSession(String hostIp, String hostPort) {
        prefs.edit().putString("hostIp", hostIp).apply();
        prefs.edit().putString("hostPort", hostPort).apply();
    }

    public void removeSession() {
        prefs.edit().remove("hostIp").apply();
        prefs.edit().remove("hostPort").apply();
    }


    public String getHostIp() {
        String hostIp = prefs.getString("hostIp","");
        return hostIp;
    }

    public String getHostPort() {
        String hostPort = prefs.getString("hostPort","");
        return hostPort;
    }
}
