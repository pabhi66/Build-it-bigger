package com.abhi.android.jokerprovider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokerProvider extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joker_provider);


        TextView jokeView = (TextView) findViewById(R.id.joke);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(Intent.EXTRA_TEXT);

        if(joke != null){
            jokeView.setText(joke);
        }

    }
}
