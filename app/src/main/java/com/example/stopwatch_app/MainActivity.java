package com.example.stopwatch_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
      TextView text1,text2;
      Button button;
      Animation atg,btsw,btgw;
      ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1=findViewById(R.id.textview);
        text2=findViewById(R.id.textview1);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Stopwatch.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        imageView=findViewById(R.id.splashimage);
        //load animations
        atg= AnimationUtils.loadAnimation(this,R.anim.atg);
        btgw=AnimationUtils.loadAnimation(this,R.anim.btgw);
        btsw=AnimationUtils.loadAnimation(this,R.anim.btsw);
        //passing Animation
        imageView.startAnimation(atg);
        text1.startAnimation(btgw);
        text2.startAnimation(btgw);
        button.startAnimation(btsw);


    }
}