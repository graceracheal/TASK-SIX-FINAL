package com.example.tasksix2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        applyFadeInAnimation();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                finish();
            }
        }, SPLASH_DURATION);
    }

    private void applyFadeInAnimation() {
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(1000);

        ImageView logo = findViewById(R.id.app_logo);
        TextView tagline = findViewById(R.id.app_tagline);

        logo.startAnimation(fadeIn);
        tagline.startAnimation(fadeIn);
    }
}