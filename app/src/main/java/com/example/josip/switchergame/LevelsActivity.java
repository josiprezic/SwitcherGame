package com.example.josip.switchergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.josip.switchergame.Util.Util;

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
                Toast.makeText(LevelsActivity.this, "pritisnuo", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
