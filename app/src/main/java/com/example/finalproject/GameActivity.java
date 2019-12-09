package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {
    private List<String> conversation = new ArrayList<>();
    int index = 0;
    private int value = 0;

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
                finish();
            }
        });
    }

    private void addStory() {
        conversation.add("(Walks in)");
        conversation.add("Good morning, everyone. This is Miki, our new exchange student this year.");
        conversation.add("Miki comes from America. She will be with us for this semester, and she will return home by the end of the semester.");
        conversation.add("Let's welcome Miki and hope she has a good time with us!");
        conversation.add("Hello everyone! Nice to meet you~!");
        conversation.add("(School ends)");
        conversation.add("Hello~");
        conversation.add("I finally meet you, Watanabe jun~");
        conversation.add("Your choice...");
        conversation.add("Ummm...He-hello.");
        conversation.add("(smiles) 'Nice to meet you' is what we say in Japanese when we first meet other people~");
        conversation.add("Haha you are right... Nice to meet you~!");
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
            //characterName.setTextColor(Color.parseColor("#2A3A7D"));
            //conversation.setTextColor(Color.parseColor("#2A3A7D"));
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
                index++;
            });
            choice2.setOnClickListener(unused -> {
                value += 2;
                conv.setText(conversation.get(index));
                narrator();
                index++;
            });
            choice3.setOnClickListener(unused -> {
                conv.setText(conversation.get(index));
                narrator();
                index++;
            });
        }
        if (index == 9) {
            choice1.setVisibility(View.INVISIBLE);
            choice2.setVisibility(View.INVISIBLE);
            choice3.setVisibility(View.INVISIBLE);
            text1.setVisibility(View.INVISIBLE);
            text2.setVisibility(View.INVISIBLE);
            text3.setVisibility(View.INVISIBLE);
        }
    }
}
