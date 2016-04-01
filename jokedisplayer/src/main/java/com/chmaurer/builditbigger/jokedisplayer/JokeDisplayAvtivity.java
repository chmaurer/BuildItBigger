package com.chmaurer.builditbigger.jokedisplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeDisplayAvtivity extends AppCompatActivity {
    public static final String JOKE_INTENT_STRING = "JOKE_INTENT_STRING";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display_avtivity);
        Intent sendingIntent = getIntent();
        String joke = sendingIntent.getStringExtra(JOKE_INTENT_STRING);
        TextView jokeTextView = (TextView) findViewById(R.id.jokeDisplayTextView);
        jokeTextView.setText(joke);
    }
}
