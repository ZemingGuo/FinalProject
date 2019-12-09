package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Chapter2Activity extends AppCompatActivity {

    private int value = getIntent().getIntExtra("value", 0);
    private int index = 0;
    private List<String> conversation = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2);
        addStory();
        ImageButton next = findViewById(R.id.next);
        TextView conv = findViewById(R.id.conversation);
        Intent intent = new Intent(this, Chapter2Activity.class);
        next.setOnClickListener(unused -> {
            if (index < conversation.size()) {
                conv.setText(conversation.get(index));
                narrator();
                index++;
            } else {
                //intent.putExtra("value", value);
                //startActivity(intent);
                finish();
            }
        });
    }

    private void addStory() {
        conversation.add("It is very late after school  and is raining outside.");
        conversation.add("You just finished your duty today and walked out of the building.");
        conversation.add("What will you do...");
        conversation.add("You take out your umbrella and walk straight out of the campus.");
        conversation.add("You didn't see Miki standing in the corner watching you leaving.");
        conversation.add(".....");
        conversation.add("You see Miki standing in the corner wearing a thin t-shirt, trembling.");
        conversation.add("It looks like she has been stood here for a while.");
        conversation.add("yo, what a coincidence! I just finished my club activity, haha.");
        conversation.add("Watanabe jun!");
        conversation.add("It seems like Miki has something to tell you but does not know where to start.");
        conversation.add("I saw you leaving for school this morning, I think I live in your next door.");
        conversation.add("Miki .");
        conversation.add("Miki smiles to you without a word and walk away.");
        conversation.add("A trace of disappointment appears in her eyes.");
    }
    private void narrator() {
        TextView characterName = findViewById(R.id.characterName);
        TextView conv = findViewById(R.id.conversation);
        ImageView miki = findViewById(R.id.miki);
        ImageView teacher = findViewById(R.id.teacher);
        ConstraintLayout game = findViewById(R.id.game);
        ImageButton choice1 = findViewById(R.id.choice1);
        ImageButton choice2 = findViewById(R.id.choice2);
        ImageButton choice3 = findViewById(R.id.choice3);
        TextView text1 = findViewById(R.id.text1);
        TextView text2 = findViewById(R.id.text2);
        TextView text3 = findViewById(R.id.text3);
        if (index == 0) {
            miki.setVisibility(View.VISIBLE);
            characterName.setVisibility(View.VISIBLE);
            characterName.setTextColor(Color.parseColor("#515151"));
            conv.setTextColor(Color.parseColor("#515151"));
        }
        if (index == 1) {
            miki.setVisibility(View.INVISIBLE);
            teacher.setVisibility(View.VISIBLE);
            characterName.setText("Teacher");
        }
        if (index == 4) {
            characterName.setText("Miki");
            teacher.setVisibility(View.INVISIBLE);
            miki.setVisibility(View.VISIBLE);
        }
        if (index == 5) {
            characterName.setVisibility(View.INVISIBLE);
            miki.setVisibility(View.INVISIBLE);
            game.setBackgroundResource(R.drawable.xiake);
        }
        if (index == 6) {
            characterName.setText("Miki");
            characterName.setVisibility(View.VISIBLE);
            miki.setVisibility(View.VISIBLE);
        }
        if (index == 8) {
            choice1.setVisibility(View.VISIBLE);
            choice2.setVisibility(View.VISIBLE);
            choice3.setVisibility(View.VISIBLE);
            text1.setVisibility(View.VISIBLE);
            text2.setVisibility(View.VISIBLE);
            text3.setVisibility(View.VISIBLE);
            choice1.setOnClickListener(unused -> {
                value += 1;
                conv.setText(conversation.get(index));
                narrator();
                index = 13;
                choice1.setVisibility(View.INVISIBLE);
                choice2.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.INVISIBLE);
                text1.setVisibility(View.INVISIBLE);
                text2.setVisibility(View.INVISIBLE);
                text3.setVisibility(View.INVISIBLE);
            });
            choice2.setOnClickListener(unused -> {
                value += 2;
                index = 10;
                conv.setText(conversation.get(index));
                narrator();
                index++;
                choice1.setVisibility(View.INVISIBLE);
                choice2.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.INVISIBLE);
                text1.setVisibility(View.INVISIBLE);
                text2.setVisibility(View.INVISIBLE);
                text3.setVisibility(View.INVISIBLE);
            });
            choice3.setOnClickListener(unused -> {
                index = 12;
                conv.setText(conversation.get(index));
                narrator();
                index++;
                choice1.setVisibility(View.INVISIBLE);
                choice2.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.INVISIBLE);
                text1.setVisibility(View.INVISIBLE);
                text2.setVisibility(View.INVISIBLE);
                text3.setVisibility(View.INVISIBLE);
            });
        }
        if (index == 10) {
            characterName.setText("You");
        }
        if (index == 11) {
            characterName.setVisibility(View.VISIBLE);
            characterName.setText("Miki");
            index += 2;
        }
        if (index == 12) {
            characterName.setVisibility(View.INVISIBLE);
        }
        if (index == 13) {
            characterName.setVisibility(View.INVISIBLE);
        }
    }
}
