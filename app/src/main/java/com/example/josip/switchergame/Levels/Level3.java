package com.example.josip.switchergame.Levels;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.josip.switchergame.R;
import com.example.josip.switchergame.Util.Util;

public class Level3 extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    Switch[] s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_level3);

        //References
        s = new Switch[3];
        s[0] = (Switch) findViewById(R.id.sw0r3);
        s[1] = (Switch) findViewById(R.id.sw1r3);
        s[2] = (Switch) findViewById(R.id.sw2r3);

        //Spremanje trenutnog levela
        Util.setLastLevel(this, 3);

        for (Switch sw : s) {
            sw.setOnCheckedChangeListener(this);
        }
    }

    //za zaustavljanje rekurzivnog poziva listenera
    boolean locker = false;
    boolean on3 = false;

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(locker)
            return;
        else
            locker = true;




        switch (buttonView.getId()) {
            case R.id.sw0r3:
                    s[1].setChecked(false);
                break;
            case R.id.sw1r3:
                if(!s[2].isChecked())
                    s[0].toggle();
                    s[2].setChecked(false);
                break;
            case R.id.sw2r3:
                if (((Switch) buttonView).isChecked())
                {
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(!on3) {
                                return;
                            } else {
                                on3 = true;
                            }
                            s[2].setChecked(false);

                        }
                    }, 2000);
                }
                break;
        }
        locker = false;
        
        if(Util.isSviUkljuceni(s)) {
            Toast.makeText(this, "Level 4", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), Level4.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }
    }
}
