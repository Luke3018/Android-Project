package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Page2 extends AppCompatActivity implements View.OnClickListener {
    //Declaration of global variables
    Button button;
    Button[][] buttons = new Button[3][3];
    Button btnNextPage;
    TextView txtout;
    EditText txtIn;
    Button btnback;
    float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        //button function to go to homepage
        btnback = (Button) findViewById(R.id.btnHome);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homePage();
            }
        });

        btnNextPage = (Button) findViewById(R.id.btnNext1);
        btnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage3();
            }
        });

        //button function takes text input and outputs in textView
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Hello world", Toast.LENGTH_SHORT).show();
                txtout = (TextView) findViewById(R.id.txtPrint);
                txtIn = (EditText) findViewById(R.id.txtInput);
                txtout.setText(txtIn.getText());

            }
        });
        //loop to set up button array for tic tac toe
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                String buttonID = "button" + x + y;
                int btnID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[x][y] = findViewById(btnID);
                buttons[x][y].setOnClickListener(this);

            }
        }

    }

    //function to run homepage button
    public void homePage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //function to run page 3
    public void openPage3() {
        Intent intent = new Intent(this, Page3.class);
        startActivity(intent);
    }

    //function to display x or y and error trap game
    @Override
    public void onClick(View v) {
        txtout = (TextView) findViewById(R.id.txtPrint);
        String player = txtout.getText().toString();

        if (player.equals("")) {
            Toast.makeText(this, "enter player", Toast.LENGTH_LONG).show();
        }
        if (player.equals("one")) {
            ((Button) v).setText("X");
            ((Button) v).setTextSize(50);
            txtout.setText("");

        } else if (player.equals("two")) {
            ((Button) v).setText("Y");
            ((Button) v).setTextSize(50);
            txtout.setText("");
        }
    }

}

