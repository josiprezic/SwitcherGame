package com.example.josip.switchergame;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.josip.switchergame.Levels.Level1;
import com.example.josip.switchergame.Levels.Level2;
import com.example.josip.switchergame.Levels.Level3;
import com.example.josip.switchergame.Levels.Level4;
import com.example.josip.switchergame.Util.Util;

public class MainActivity extends AppCompatActivity {
    Button btPlay;
    Button btLevels;
    Button btInstructions;
    Button btOptions;
    Button btExit;
    Button btContinue;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reference
        btPlay = (Button) findViewById(R.id.btPlay);
        btLevels = (Button) findViewById(R.id.btLevels);
        btInstructions = (Button) findViewById(R.id.btInstructions);
        btOptions = (Button) findViewById(R.id.btOptions);
        btExit = (Button) findViewById(R.id.btExit);
        btContinue = (Button) findViewById(R.id.btContinue);

        //Blocking continue button if needed
        if(Util.getLastLevel(this) == 0) {
            btContinue.setEnabled(false);
        }

        //Start the game
        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Level1.class);
                startActivity(intent);
            }
        });

        btContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class levelClass;
                int lastLevel = Util.getLastLevel(MainActivity.this);

                switch (lastLevel) {
                    case 0:
                    case 1:
                        levelClass = Level1.class;
                        break;
                    case 2:
                        levelClass = Level2.class;
                        break;
                    case 3:
                        levelClass = Level3.class;
                        break;
                    case 4:
                        levelClass = Level4.class;
                        break;
                    case 5:
                    case 6:
                    default: levelClass = MainActivity.class;
                            break;
                }

                Intent intent = new Intent(getApplicationContext(), levelClass);
                startActivity(intent);

            }
        });

        btLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //otvaranje liste levela
                Intent intent = new Intent(getApplicationContext(), LevelsActivity.class);
                startActivity(intent);
            }
        });


        btInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InstructionsActivity.class);
                startActivity(intent);
            }
        });

        btOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OptionsActivity.class);
                startActivity(intent);
            }
        });

        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
