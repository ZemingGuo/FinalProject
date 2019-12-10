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

    private int value = GameActivity.getValue();
    private int index = 0;
    private List<String> conversation = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2);
        addStory();
        ImageButton next = findViewById(R.id.next);
        TextView conv = findViewById(R.id.conversation);
        //Intent intent = new Intent(this, Chapter2Activity.class);
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
        conversation.add("It is very late after school and is raining outside.");
        conversation.add("You just finished your duty today and walked out of the building.");
        conversation.add("What will you do...");
        //choice 1
        conversation.add("You take out your umbrella and walk straight out of the campus.");
        conversation.add("You didn't see Miki standing in the corner watching you leaving.");
        conversation.add(".....");
        //choice 3
        conversation.add("You run to Miki's house, thinking of asking her out for a dinner.");
        conversation.add("Unfortunately, Miki is not at home. But her little sister sees you.");
        //choice 2
        conversation.add("You see Miki standing in the corner wearing a thin t-shirt, trembling.");
        conversation.add("It looks like she has been stood here for a while.");
        conversation.add("Yo, what a coincidence! I just finished my club activity, haha.");
        conversation.add("Watanabe jun!");
        conversation.add("It seems like Miki has something to tell you but does not know where to start.");
        conversation.add("I saw you leaving for school this morning, I think I live in your next door.");
        conversation.add("So...you want to walk home together?");
        conversation.add("But the weather report didn't say it's going to rain...");
        conversation.add("(You put the umbrella over her head)");
        conversation.add("Then let's walk together.");
        conversation.add("Drops of rain fall on Miki's flushing face, as she walks by your side like a little trembling kitty.");
        conversation.add("What do you do...");

       //choice 1 借衣服
        conversation.add("Thank you...Riku jun");
        conversation.add("It feels warm, like Riku jun is always by my side.");
        //choice 2 偏雨伞
        conversation.add("Miki does not say a word, but she walks closer to you.");
        //choice 3 给她上一课
        conversation.add("Next time remember to bring your umbrella, just in case.");
        conversation.add("Miki remains silent along the way.");
    }
    private void narrator() {
        TextView characterName = findViewById(R.id.characterName);
        TextView conv = findViewById(R.id.conversation);
        ImageView miki = findViewById(R.id.miki);
        ConstraintLayout game = findViewById(R.id.game);
        ImageButton choice1 = findViewById(R.id.choice1);
        ImageButton choice2 = findViewById(R.id.choice2);
        ImageButton choice3 = findViewById(R.id.choice3);
        TextView text1 = findViewById(R.id.text1);
        TextView text2 = findViewById(R.id.text2);
        TextView text3 = findViewById(R.id.text3);
        ImageButton next = findViewById(R.id.next);
        if (index == 2) {
            choice1.setVisibility(View.VISIBLE);
            choice2.setVisibility(View.VISIBLE);
            choice3.setVisibility(View.VISIBLE);
            text1.setVisibility(View.VISIBLE);
            text2.setVisibility(View.VISIBLE);
            text3.setVisibility(View.VISIBLE);
            next.setVisibility(View.INVISIBLE);
            text1.setText("It's raining hard. I'll just go home.");
            text2.setText("Look around");
            text3.setText("Go to Miki's house");
            choice1.setOnClickListener(unused -> {
                conv.setText(conversation.get(index));
                narrator();
                index++;
                choice1.setVisibility(View.INVISIBLE);
                choice2.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.INVISIBLE);
                text1.setVisibility(View.INVISIBLE);
                text2.setVisibility(View.INVISIBLE);
                text3.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);
            });
            choice2.setOnClickListener(unused -> {
                value += 2;
                index = 8;
                conv.setText(conversation.get(index));
                narrator();
                index++;
                choice1.setVisibility(View.INVISIBLE);
                choice2.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.INVISIBLE);
                text1.setVisibility(View.INVISIBLE);
                text2.setVisibility(View.INVISIBLE);
                text3.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);
            });
            choice3.setOnClickListener(unused -> {
                value += 1;
                index = 6;
                conv.setText(conversation.get(index));
                narrator();
                index++;
                choice1.setVisibility(View.INVISIBLE);
                choice2.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.INVISIBLE);
                text1.setVisibility(View.INVISIBLE);
                text2.setVisibility(View.INVISIBLE);
                text3.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);
            });
        }
        if (index == 5) {
            index = 25;
        }
        if (index == 7) {
            index = 25;
        }
        if (index == 8) {
            game.setBackgroundResource(R.drawable.xiayu);
        }
        if (index == 10) {
            characterName.setVisibility(View.VISIBLE);
            characterName.setText("You");
        }
        if (index == 11) {
            characterName.setText("Miki");
        }
        if (index == 12) {
            characterName.setVisibility(View.INVISIBLE);
        }
        if (index == 13) {
            characterName.setVisibility(View.VISIBLE);
            characterName.setText("Miki");
        }
        if (index == 14) {
            characterName.setText("You");
        }
        if (index == 15) {
            characterName.setText("Miki");
        }
        if (index == 16) {
            characterName.setVisibility(View.INVISIBLE);
        }
        if (index == 17) {
            characterName.setVisibility(View.VISIBLE);
            characterName.setText("You");
        }
        if (index == 18) {
            characterName.setVisibility(View.INVISIBLE);
        }
        if (index == 19) {
            choice1.setVisibility(View.VISIBLE);
            choice2.setVisibility(View.VISIBLE);
            choice3.setVisibility(View.VISIBLE);
            text1.setVisibility(View.VISIBLE);
            text2.setVisibility(View.VISIBLE);
            text3.setVisibility(View.VISIBLE);
            next.setVisibility(View.INVISIBLE);
            text1.setText("Give her your coat.");
            text1.setTextSize(22);
            text2.setText("Lean the umbrella towards her.");
            text2.setTextSize(18);
            text3.setText("Tell her not to forget umbrella.");
            text3.setTextSize(18);
            choice1.setOnClickListener(unused -> {
                value += 2;
                conv.setText(conversation.get(index));
                narrator();
                index++;
                choice1.setVisibility(View.INVISIBLE);
                choice2.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.INVISIBLE);
                text1.setVisibility(View.INVISIBLE);
                text2.setVisibility(View.INVISIBLE);
                text3.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);
            });
            choice2.setOnClickListener(unused -> {
                value += 1;
                index = 22;
                conv.setText(conversation.get(index));
                narrator();
                index++;
                choice1.setVisibility(View.INVISIBLE);
                choice2.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.INVISIBLE);
                text1.setVisibility(View.INVISIBLE);
                text2.setVisibility(View.INVISIBLE);
                text3.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);
            });
            choice3.setOnClickListener(unused -> {
                index = 23;
                conv.setText(conversation.get(index));
                narrator();
                index++;
                choice1.setVisibility(View.INVISIBLE);
                choice2.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.INVISIBLE);
                text1.setVisibility(View.INVISIBLE);
                text2.setVisibility(View.INVISIBLE);
                text3.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);
            });
        }
        if (index == 20) {
            characterName.setVisibility(View.VISIBLE);
            characterName.setText("Miki");
        }
        if (index == 21) {
            index = 25;
        }
        if (index == 22) {
            characterName.setVisibility(View.INVISIBLE);
            index = 25;
        }
        if (index == 23) {
            characterName.setVisibility(View.VISIBLE);
            characterName.setText("You");
        }
        if (index == 24) {
            characterName.setVisibility(View.INVISIBLE);
            index = 25;
        }
    }
}
