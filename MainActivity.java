package com.example.idle_tap_game_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //global variable declaration
    Button btnup;
    Button btnnext;
    Button btnR;
    Button btnL;
    TextView txtOut;
    int Score = 0;
    int perks;
    boolean multiplier = false;
    public static final String SHARED_PREFS = "sharedPrefs";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //calls intents to save and load the score on opening the app.
        Back();
        load();
        savedata();

        //intent to see if the shop has been opened.
        Intent Pintent = getIntent();
        multiplier = Pintent.getBooleanExtra("P", false);

        //Intent perkIntent = getIntent();
        //perks = perkIntent.getIntExtra("perk", 0);


        //set lable to to txtout.
        txtOut = (TextView) findViewById(R.id.txtScore);

        //button to reset the score for test proposes.
        btnR = (Button) findViewById(R.id.btnReset);
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Score = 0;
            }
        });

        //button to increase the score by one
        btnup = (Button) findViewById(R.id.btnclick);
        btnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if statement to increase the score and check the shop.
                if (multiplier) {
                    Back(); //call get score from shop class.
                    ScorePerks();
                    Score += perks;
                    txtOut.setText("" + Score);
                    savedata(); //call save intent to save score in shared preference.
                    multiplier = false; //set to false to run next time.
                } else if (Score >= 0 && perks == 0) {
                    Score ++;
                    txtOut.setText("" + Score);
                    savedata();
                } else {
                    Score+= perks;
                    txtOut.setText("" + Score);
                    //Toast.makeText(MainActivity.this, "" + Score,Toast.LENGTH_SHORT).show();
                    savedata();
                }
            }
        });

        //calls intents to save and load the score on opening the app.
        savedata();
        Back();
        load();

        //button to call intent to go to shop class
        btnnext = (Button) findViewById(R.id.btnShop);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShop();
            }
        });
    }

    //intent to pass score to shop class.
    public void openShop() {
        Intent intent = new Intent(MainActivity.this, Shop.class);
        intent.putExtra("key", Score);
        startActivity(intent);
    }

    //intent to receive new score from shop class.
    public void Back() {
        Intent nintent = getIntent();
        Score = nintent.getIntExtra("B", 0);
    }

    //save score in sharedPreference(ROM).
    public void  savedata() {
        SharedPreferences save = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        editor.putInt("Points", Score);
        editor.putInt("Perks", perks);
        editor.apply();

    }

    //load score back into program on opening.
    public void load() {
        SharedPreferences unLoad = getPreferences(MODE_PRIVATE);
        Score = unLoad.getInt("Points", 0);
        perks = unLoad.getInt("Perks", 0);
    }

    public void ScorePerks() {
        Intent perkIntent = getIntent();
        perks = perkIntent.getIntExtra("perk", 0);
    }



}
