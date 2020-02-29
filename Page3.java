package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Page3 extends AppCompatActivity {
    Button btnHomePage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        //button function to go to homepage
        btnHomePage = (Button) findViewById(R.id.btnHome);
        btnHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homePage();
            }
        });
    }
    //functions to change to link pages
    public void linkPage1(View view) {
        Intent LinkPage1Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://store.steampowered.com/"));
        startActivity(LinkPage1Intent);
    }
    public void linkPage2(View view) {
        Intent linkPage2Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bbc.co.uk/news"));
        startActivity(linkPage2Intent);
    }
    public void linkPage3(View view) {
        Intent linkPage3Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.brookes.ac.uk/students/"));
        startActivity(linkPage3Intent);
    }

    public void homePage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
