package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;

public class Chapter2Activity extends AppCompatActivity {

    private int value = getIntent().getIntExtra("value", 0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2);
        ConstraintLayout game = findViewById(R.id.game);
        System.out.println(value);
        if (value == 1) {
            game.setBackgroundResource(R.drawable.jiaoshi);
        }
    }
}
