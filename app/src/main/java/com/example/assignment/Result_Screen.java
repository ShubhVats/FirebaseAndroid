package com.example.assignment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result_Screen extends AppCompatActivity {

    TextView Restext1, Restext2, Restext3, Restext4, Restext5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);
        Restext1 = findViewById(R.id.Restext1);
        Restext2 = findViewById(R.id.Restext2);
        Restext3 = findViewById(R.id.Restext3);
        Restext4 = findViewById(R.id.Restext4);
        Restext5 = findViewById(R.id.Restext5);

        String Text1 = getIntent().getStringExtra("Text1");
        String Text2 = getIntent().getStringExtra("Text2");
        String Text3 = getIntent().getStringExtra("Text3");
        String Text4 = getIntent().getStringExtra("Text4");
        String Text5 = getIntent().getStringExtra("Text5");

        Restext1.setText(Text1);
        Restext2.setText(Text2);
        Restext3.setText(Text3);
        Restext4.setText(Text4);
        Restext5.setText(Text5);
    }
}