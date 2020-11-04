package com.example.idle_tap_game_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Shop extends AppCompatActivity {
    int Score;
    int perks;
    boolean multiplier;
    Button btnb;
    Button btnTimes2;
    TextView txtPrint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        //intent to receive score from main class
        Intent intent = getIntent();
        Score = intent.getIntExtra("key", 0);

        load();

        //back to main class an subtract form score.
        btnb = (Button) findViewById(R.id.btnBack);
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });

        btnTimes2 = (Button) findViewById(R.id.btnX2);
        btnTimes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent PerkIntent = getIntent();
                //perks = PerkIntent.getIntExtra("PP", 0);
                if (Score <= 0) {
                    btnTimes2.setEnabled(false);
                    Toast.makeText(Shop.this, "out of score points", Toast.LENGTH_SHORT).show();
                } else {
                    perks += 2;
                    Score -=20;
                    multiplier = true;
                    txtPrint = (TextView) findViewById(R.id.txtOut);
                    txtPrint.setText("" + Score + " " + perks);
                    SavePerks();
                }
            }
        });
    }

    public void openMain() {
        Intent back = new Intent(Shop.this, MainActivity.class);
        back.putExtra("B", Score);
        back.putExtra("P", multiplier);
        back.putExtra("perk", perks);
        startActivity(back);
    }

    public void SavePerks() {
        SharedPreferences save = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        editor.putInt("save", perks);
        editor.apply();
    }

    public void load() {
        SharedPreferences unload = getPreferences(MODE_PRIVATE);
        perks = unload.getInt("save", 0);
    }
}
