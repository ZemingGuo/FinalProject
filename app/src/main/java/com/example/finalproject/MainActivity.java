package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private ImageButton pause, play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startGame = findViewById(R.id.startGame);
        Intent intent = new Intent(this, GameActivity.class);
        startGame.setOnClickListener(unused -> startActivity(intent));
        pause = findViewById(R.id.pause);
        play = findViewById(R.id.play);
    }
}
