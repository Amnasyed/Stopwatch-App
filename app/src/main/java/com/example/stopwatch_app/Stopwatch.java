package com.example.stopwatch_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class Stopwatch extends AppCompatActivity {
       ImageView image3;
       Animation animation;
       Button buttonstart,buttonfinish;
       Chronometer meter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        buttonstart=findViewById(R.id.buttonstart);
        meter=findViewById(R.id.meter);
        image3=findViewById(R.id.stopneedle);
        buttonfinish=findViewById(R.id.buttonfinish);
        //load animations

        animation=AnimationUtils.loadAnimation(this,R.anim.rotateneedle);
        //optional button
        buttonfinish.setAlpha(0);
        buttonfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation.restrictDuration(0);      //stopped needle
                meter.stop();
            }
        });
        buttonstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image3.startAnimation(animation); //add
                buttonfinish.animate().alpha(1).translationY(-80).setDuration(300).start();
                buttonstart.animate().alpha(0).setDuration(300).start();
                //start time chronmomter
                meter.setBase(SystemClock.elapsedRealtime());
                meter.start();
            }
        });



    }
}