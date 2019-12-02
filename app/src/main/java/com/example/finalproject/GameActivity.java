package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        List<String> conversation = new ArrayList<String>();

        ImageButton next = findViewById(R.id.next);
        TextView conv = findViewById(R.id.conversation);
        next.setOnClickListener(unused -> conv.setText("其实我一直都很喜欢你！"));


    }
}
