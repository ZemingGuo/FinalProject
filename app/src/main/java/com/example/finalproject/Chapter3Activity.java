package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Chapter3Activity extends AppCompatActivity {

    private static int value = Chapter2Activity.getValue();
    private int index = 0;
    private List<String> conversation = new ArrayList<>();
    private MediaPlayer mMediaPlayer;
    private ImageButton pause, play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter3);
        mMediaPlayer = MediaPlayer.create(this, R.raw.gaobie);
        mMediaPlayer.start();
        addStory();
        ImageButton next = findViewById(R.id.next);
        TextView conv = findViewById(R.id.conversation);
        Intent intent = new Intent(this, Chapter4Activity.class);
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
                if (index == 27 && value < 5) {
                    index = 35;
                }
                conv.setText(conversation.get(index));
                narrator();
                index++;
            } else {
                if (value >= 5) {
                    value = 0;
                    finish();
                    mMediaPlayer.release();
                    startActivity(intent);
                } else {
                    value = 0;
                    finish();
                    mMediaPlayer.release();
                }
            }
        });
    }

    private void addStory() {
        conversation.add("This semester passes as if it is in a blink of eyes");
        conversation.add("Sitting next to me, Miki and I has become great friends");
        conversation.add("Or...more than just friends, I think.");
        conversation.add("The time I spent with Miki was always joyful.");
        conversation.add("Although she is from America, a completely different place from where I grow up,");
        conversation.add("when I am with her, I feel like it could my best memory throughout high school.");
        conversation.add("In past few years, I felt like every day was same.");
        conversation.add("I did the same thing every day -- go to school, take classes, and then go home.");
        conversation.add("But things has changed when Miki came into my life.");
        conversation.add("I started enjoy every day at school.");
        conversation.add("When I wake up in the morning and I realize that I will see her and talk to her, I start to enjoy my day.");
        conversation.add("Yes, from some perspective, I like her.");
        conversation.add("But now it's the time to say good-bye.");
        conversation.add("...");
        conversation.add("(Morning)");
        conversation.add("At the gate of Miki's house. You are here to say good-bye.");
        //女主
        conversation.add("Riku!");
        //男主
        conversation.add("Hey Miki...I'm here to say good-bye.");
        conversation.add("It's nice to meet you!");
        //女主
        conversation.add("It's nice to meet you...I feel so lucky to know person like you.");
        conversation.add("You know...it has been hard for me to stay in Japan...because of those language barriers.");
        conversation.add("But you really helped me walk through those struggles.");
        conversation.add("Thank you so much for those,");
        conversation.add("and...I really had a great time with you...it's now my favorite memories.");
        //男主
        conversation.add("Good luck, Miki.");
        conversation.add("You deserve a bright future.");
        //女主
        conversation.add("Thank you...");
        //好感度 > 5
        conversation.add("and these are for you. They are special.");
        //旁边
        conversation.add("(Miki hands you a bunch of flowers)");
        conversation.add("You recall that those are the flowers that bloom in spring at the park I used to play when I was young.");
        conversation.add("Then Miki left.");
        conversation.add("(Night)");
        conversation.add("I put the flowers in a vase. They are not the pretties flowers I have seen...");
        conversation.add("but...they look familiar...");
        conversation.add("I finally recalled something...");
        //好感度 < 5
        //女主
        conversation.add("Hope you have fun for the rest of high school time.");
        //旁白
        conversation.add("(Miki then left)");
        conversation.add("...");
        conversation.add("Years have passed.");
        conversation.add("I then got into a college in Tokyo and had a great college life.");
        conversation.add("And I have never seen Miki again.");
        conversation.add("But that's ok since I know that she must be doing well in her country.");
        conversation.add("And I now enjoy my college life with a bunch of new friends");
        conversation.add("But life is like a journey,");
        conversation.add("and things will change if I make different decisions...");
        conversation.add("---NORMAL END---");
    }

    private void narrator() {
        TextView characterName = findViewById(R.id.characterName);
        ImageView miki = findViewById(R.id.miki);
        ConstraintLayout game = findViewById(R.id.game);
        ImageButton next = findViewById(R.id.next);
        if (index == 16) {
            game.setBackgroundResource(R.drawable.ends);
            characterName.setVisibility(View.VISIBLE);
            characterName.setText("Miki");
        }
        if (index == 17) {
            characterName.setText("You");
        }
        if (index == 19) {
            characterName.setText("Miki");
        }
        if (index == 24) {
            characterName.setText("You");
        }
        if (index == 26) {
            characterName.setText("Miki");
        }
        if (index == 28) {
            characterName.setVisibility(View.INVISIBLE);
            game.setBackgroundResource(R.drawable.black);
        }
        if (index == 34) {
            index = 46;
        }
        if (index == 36) {
            characterName.setVisibility(View.INVISIBLE);
            game.setBackgroundResource(R.drawable.black);
        }
    }

    public static int getValue() {
        return value;
    }
}
