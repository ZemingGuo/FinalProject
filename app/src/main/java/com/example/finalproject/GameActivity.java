package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {
    private List<String> conversation = new ArrayList<>();
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        addStory();
        ImageButton next = findViewById(R.id.next);
        TextView conv = findViewById(R.id.conversation);
        next.setOnClickListener(unused -> {
            if (index < conversation.size()) {
                conv.setText(conversation.get(index));
                narrator();
                index++;
            } else {
                if (index == conversation.size()) {
                    finish();
                }
            }
        });
    }

    private void addStory() {
        conversation.add("Hey！");
        conversation.add("My name is Miki!");
        conversation.add("Nice to meet you!");
        conversation.add("Nice to meet you!");
    }
    private void narrator() {
        TextView characterName = findViewById(R.id.characterName);
        TextView conversation = findViewById(R.id.conversation);
        if (index == 0) {
            characterName.setVisibility(View.VISIBLE);
            characterName.setTextColor(Color.parseColor("#515151"));
            conversation.setTextColor(Color.parseColor("#515151"));
        }
        if (index == 2) {
            characterName.setText("You");
            characterName.setTextColor(Color.parseColor("#2A3A7D"));
            conversation.setTextColor(Color.parseColor("#2A3A7D"));
        }
        if (index == 3) {
            characterName.setText("Miki");
            characterName.setTextColor(Color.parseColor("#515151"));
            conversation.setTextColor(Color.parseColor("#515151"));
        }
    }
}
