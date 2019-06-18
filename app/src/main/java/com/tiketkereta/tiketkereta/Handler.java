package com.tiketkereta.tiketkereta;

public class Handler {
    public static final String URL_LOGIN = "http://192.162.43.17/TiketKereta/login.php";
    public static final String URL_REGISTER = "http://192.162.43.17/TiketKereta/register.php";

    public static String getUrlRegister() {
        return URL_REGISTER;
    }

    public static String getUrlLogin() {
        return URL_LOGIN;
    }
}
