package com.example.josip.switchergame.Levels;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.josip.switchergame.MainActivity;
import com.example.josip.switchergame.R;
import com.example.josip.switchergame.Util.Util;

public class Level4 extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    Switch[] s;
    boolean locker;
    int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level4);
        max = 4;
        s = new Switch[4];
        s[0] = (Switch) findViewById(R.id.sw0r4);
        s[1] = (Switch) findViewById(R.id.sw1r4);
        s[2] = (Switch) findViewById(R.id.sw2r4);
        s[3] = (Switch) findViewById(R.id.sw3r4);

        for (Switch sw : s) {
            sw.setOnCheckedChangeListener(this);
        }

        //Spremanje trenutnog levela
        Util.setLastLevel(this, 4);

        locker = false;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (locker) {
            return;
        }
        locker = true;
        Switch tretutni = (Switch) buttonView;
        int index = Util.getIndexSwitcha(buttonView, s);
        s[Util.getIndexBefore(index, max)].toggle();
        s[Util.getIndexAfter(index, max)].toggle();
        locker = false;

        if(Util.isSviUkljuceni(s)) {
            Toast.makeText(this, "Level 5", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }
    }
}
