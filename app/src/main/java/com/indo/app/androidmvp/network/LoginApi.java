package com.indo.app.androidmvp.network;

/**
 * Created by indo on 23/12/17.
 */

public class LoginApi {

    private final String USERNAME = "indo";
    private final String PASSWORD = "12146909";
    public boolean authenticate(String username, String password) {
    if (USERNAME.equals(username)&& PASSWORD.equals(password)){
        return  true;

    }
    return false;
    }
}
