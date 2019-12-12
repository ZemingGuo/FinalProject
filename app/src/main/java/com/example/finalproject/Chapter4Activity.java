package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Chapter4Activity extends AppCompatActivity {

    private static int value = Chapter3Activity.getValue();
    private int index = 0;
    private List<String> conversation = new ArrayList<>();
    private MediaPlayer mMediaPlayer;
    private ImageButton pause, play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter4);
        mMediaPlayer = MediaPlayer.create(this, R.raw.huiyi);
        mMediaPlayer.start();
        addStory();
        ImageButton next = findViewById(R.id.next);
        TextView conv = findViewById(R.id.conversation);
        //Intent intent = new Intent(this, Chapter4Activity.class);
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
                //startActivity(intent);
                finish();
                mMediaPlayer.release();
                //startActivity(intent);
            }
        });
    }

    private void addStory() {
        //旁白
        conversation.add("Miki's parents came to Japan to do business. At that time, Miki and Riku lived in the same neighborhood.");
        //女主
        conversation.add("Hello...My name is M..M..iki...");
        conversation.add("Nice to meet you guys....");
        //旁白
        conversation.add("Miki standing beside a crowed of Japanese kids and speaking nervously.");
        conversation.add("But she didn't get any answer from the kids, because those kids didn't " +
                "want to play with a foreigner who can not even speak Japanese coherently.");
        //女主
        conversation.add("Ummm...");
        //旁白
        conversation.add("Little Miki standing there with tears in her eyes.");
        //男主
        conversation.add("Hey, what your name!");
        //女主
        conversation.add("M..Miki.");
        //旁白
        conversation.add("The boy was different from any other kid Miki had met before.");
        conversation.add("He has an amiable smile, like the sun in the sky.");
        //男主
        conversation.add("My name is Riku! Let's go to the garden! I will show you some lovely flowers!");
        //女主
        conversation.add("...");
        //旁白
        conversation.add("From then on, they became each other's best friend.");
        conversation.add("Until one day....");
        conversation.add("Miki's parents took her back to America.");
        conversation.add("Then I have never seen her again...");
        conversation.add("Until I saw Miki in my class.");
        conversation.add("She must be Miki from my childhood.");
        conversation.add("And I finally recall her...");
        conversation.add("...");
        conversation.add("(One year later)");
        conversation.add("I finally graduated and I got into a college in America.");
        conversation.add("I finally come to where she grows up.");
        conversation.add("...");
        conversation.add("(On the first day of school)");
        conversation.add("Hey Riku!!!");
        conversation.add("Oh Miki!!!!!");
        conversation.add("What a coincidence!!!!");
        conversation.add("Well...I guess that what we call a \"suprise\"!");
        conversation.add("---HAPPY END---");
    }
    private void narrator() {
        TextView characterName = findViewById(R.id.characterName);
        ImageView miki = findViewById(R.id.miki);
        ImageView daxue = findViewById(R.id.daxue);
        ConstraintLayout game = findViewById(R.id.game);
        ImageButton next = findViewById(R.id.next);
        if (index == 1) {
            characterName.setVisibility(View.VISIBLE);
            characterName.setText("Young Miki");
            miki.setVisibility(View.VISIBLE);
        }
        if (index == 3) {
            characterName.setVisibility(View.INVISIBLE);
            miki.setVisibility(View.INVISIBLE);
        }
        if (index == 5) {
            characterName.setVisibility(View.VISIBLE);
            characterName.setText("Young Miki");
            miki.setVisibility(View.VISIBLE);
        }
        if (index == 6) {
            characterName.setVisibility(View.INVISIBLE);
            miki.setVisibility(View.INVISIBLE);
        }
        if (index == 7) {
            characterName.setVisibility(View.VISIBLE);
            characterName.setText("You");
            miki.setVisibility(View.VISIBLE);
        }
        if (index == 8) {
            characterName.setText("Young Miki");
        }
        if (index == 9) {
            characterName.setVisibility(View.INVISIBLE);
            miki.setVisibility(View.INVISIBLE);
        }
        if (index == 11) {
            characterName.setVisibility(View.VISIBLE);
            characterName.setText("You");
            miki.setVisibility(View.VISIBLE);
        }
        if (index == 12) {
            characterName.setText("Young Miki");
        }
        if (index == 13) {
            characterName.setVisibility(View.INVISIBLE);
            game.setBackgroundResource(R.drawable.black);
            miki.setVisibility(View.INVISIBLE);
        }
        if (index == 26) {
            characterName.setVisibility(View.VISIBLE);
            characterName.setText("Miki");
            game.setBackgroundResource(R.drawable.daxue);
            daxue.setVisibility(View.VISIBLE);
        }
        if (index ==27) {
            characterName.setText("You");
        }
        if (index == 28) {
            characterName.setText("Miki & You");
        }
        if (index == 29) {
            characterName.setVisibility(View.INVISIBLE);
            game.setBackgroundResource(R.drawable.black);
            daxue.setVisibility(View.INVISIBLE);
            //..
        }
    }
}
