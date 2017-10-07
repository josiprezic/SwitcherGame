package com.example.josip.switchergame.Levels;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.josip.switchergame.R;
import com.example.josip.switchergame.Util.Util;

public class Level2 extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    Switch[] s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_level2);

        //reference
        s = new Switch[2];
        s[0] = (Switch) findViewById(R.id.sw1r2);
        s[1] = (Switch) findViewById(R.id.sw2r2);

        //listeners
        s[0].setOnCheckedChangeListener(this);
        s[1].setOnCheckedChangeListener(this);

        //Spremanje trenutnog levela
        Util.setLastLevel(this, 2);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.sw1r2:
                break;
            case R.id.sw2r2:
                s[0].setChecked(false);
                break;
        }

        //Provjera da li su svi switchevi ukljuceni
        if (Util.isSviUkljuceni(s)) {
            Toast.makeText(this, "Level 3", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), Level3.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }
    }
}