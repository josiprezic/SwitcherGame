package com.example.josip.switchergame.Util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Switch;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Josip on 28-Sep-17.
 */

public class Util {

    public static final String LEVEL = "level";
    public static final String MY_PREFS_FILE = "info";

    private Util() {
    }

    ;

    public static boolean isSviUkljuceni(Switch[] s) {
        for (Switch sw : s) {
            if (!sw.isChecked())
                return false;
        }
        return true;
    }

    public static void pogasiSveOsimJednog(View v, Switch[] s) {
        for (Switch sw : s) {
            if (sw.getId() != v.getId()) {
                sw.setChecked(false);
            }
        }
    }

    public static void promijeniSveOsimJednog(View v, Switch[] s) {
        for (Switch sw : s) {
            if (sw.getId() != v.getId()) {
                sw.toggle();
            }
        }
    }

    public static int getIndexSwitcha(View v, Switch[] s) {
        int index = 0;
        for (Switch sw : s) {
            if (v.getId() == s[index].getId())
                return index;
            index++;
        }

        return -1;
    }

    public static int getIndexBefore(int i, int max) {
        if (i > 0)
            return i - 1;
        return max - 1;
    }

    public static int getIndexAfter(int i, int max) {
        i++;
        if (i == max)
            return 0;
        return i;
    }

    public static void setLastLevel(Activity a, int currentLevel) {
        SharedPreferences pref = a.getApplicationContext().getSharedPreferences(MY_PREFS_FILE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt(LEVEL, currentLevel);
        editor.apply();
    }

    public static int getLastLevel(Activity a) {
        SharedPreferences pref = a.getApplicationContext().getSharedPreferences(MY_PREFS_FILE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        int level = pref.getInt(LEVEL, 0);
        return level;
    }
}
