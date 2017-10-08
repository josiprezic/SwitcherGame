package com.example.josip.switchergame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.josip.switchergame.Levels.Level1;
import com.example.josip.switchergame.Levels.Level2;
import com.example.josip.switchergame.Levels.Level3;
import com.example.josip.switchergame.Levels.Level4;
import com.example.josip.switchergame.Util.Util;

import java.util.logging.Level;

public class LevelsActivity extends AppCompatActivity {

    GridView gridView;
    int[] levels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        gridView = (GridView) findViewById(R.id.gridView);

        int brojLevela = Util.getLastLevel(this);

        GridAdapter gridAdapter = new GridAdapter(LevelsActivity.this, brojLevela);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Class klasa;
                switch (position + 1) {
                    case 0:
                    case 1:
                        klasa = Level1.class;
                        break;
                    case 2:
                        klasa = Level2.class;
                        break;
                    case 3:
                        klasa = Level3.class;
                        break;
                    case 4:
                        klasa = Level4.class;
                        break;
                    case 5:
                    default:
                        klasa = Level1.class;
                        break;
                }

                Intent intent = new Intent(getApplicationContext(), klasa);
                startActivity(intent);
                finish();

            }
        });
    }
}
