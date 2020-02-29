package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    //Declaration of global variables
    Button btnNext;
    Button btnNext2;
    float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button function change to page2
        btnNext = (Button) findViewById(R.id.btn2);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage2();
            }
        });

        btnNext2 =(Button) findViewById(R.id.btnPage3);
        btnNext2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openPage3();
           }
        });
}
    //function to run activity to change page 2
    public void openPage2() {
        Intent intent = new Intent(this, Page2.class);
        startActivity(intent);

    }
    //function to run activity to change page 3
    public void openPage3() {
        Intent intent = new Intent(this, Page3.class);
        startActivity(intent);
    }
    

}



