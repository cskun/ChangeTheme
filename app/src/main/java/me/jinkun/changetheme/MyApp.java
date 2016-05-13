package me.jinkun.changetheme;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Description: Do one thing at a time, and do well.</br>
 * Autor: Created by jinkun on 2016/5/13.
 */
public class MyApp extends Application {
    public static final int THEME_NIGHT = 0;
    public static final int THEME_LIGHT = 1;

    private static MyApp _instance;

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;
    }

    public static MyApp getInstance() {
        return _instance;
    }

    public SharedPreferences getGlobleSp() {
        return getSharedPreferences("config", Context.MODE_PRIVATE);
    }

    public int getGlobleTheme() {
        return getGlobleSp().getInt("theme", THEME_NIGHT);
    }

    public void changeGlobleTheme() {
        getGlobleSp().edit().putInt("theme", getGlobleTheme() == THEME_LIGHT ? THEME_NIGHT : THEME_LIGHT).commit();
    }
}
