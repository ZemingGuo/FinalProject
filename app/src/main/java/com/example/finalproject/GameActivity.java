package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
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
    private static int value = 0;
    private MediaPlayer mMediaPlayer;
    private ImageButton pause, play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mMediaPlayer = MediaPlayer.create(this, R.raw.wind);
        mMediaPlayer.start();
        addStory();
        ImageButton next = findViewById(R.id.next);
        TextView conv = findViewById(R.id.conversation);
        Intent intent = new Intent(this, Chapter2Activity.class);
        pause = findViewById(R.id.pause);
        play = findViewById(R.id.play);
        play.setVisibility(View.INVISIBLE);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.start();
                play.setVisibility(View.INVISIBLE);
                pause.setVisibility(View.VISIBLE);
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.pause();
                pause.setVisibility(View.INVISIBLE);
                play.setVisibility(View.VISIBLE);
            }
        });
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
        next.setOnClickListener(unused -> {
            if (index < conversation.size()) {
                conv.setText(conversation.get(index));
                narrator();
                index++;
            } else {
                //intent.putExtra("value", value);
                finish();
                mMediaPlayer.release();
                startActivity(intent);
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
        conversation.add("(Smiles) 'Nice to meet you' is what we say in Japanese when we first meet other people~");
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
        ImageButton next = findViewById(R.id.next);
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
            next.setVisibility(View.INVISIBLE);
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
                next.setVisibility(View.VISIBLE);
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
                next.setVisibility(View.VISIBLE);
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
                next.setVisibility(View.VISIBLE);
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

    public static int getValue() {
        return value;
    }


}
