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

public class Level1 extends AppCompatActivity {

    Switch sw1r1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_level1);

        //reference
        sw1r1 = (Switch) findViewById(R.id.sw1r1);

        //Listeners
        sw1r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                play();
            }
        });

        //Spremanje trenutnog levela
        Util.setLastLevel(this, 1);
    }

    public void play() {
        if (sw1r1.isChecked()) {
            Toast.makeText(Level1.this, "Level 2", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), Level2.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }
    }
}
