package com.example.tasksix2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_DURATION = 3000;
    private View splashContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        splashContent = findViewById(R.id.splash_content);
        fadeInSplashContent();

        moveToMainScreenAfterDelay();
    }

    private void fadeInSplashContent() {
        ObjectAnimator fadeAnimation = ObjectAnimator.ofFloat(splashContent, "alpha", 0f, 1f);

        fadeAnimation.setDuration(1000);
        fadeAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        fadeAnimation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
            }
        });

        fadeAnimation.start();
    }
    private void moveToMainScreenAfterDelay() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goToDashboardScreen();
            }
        }, SPLASH_DURATION);
    }

    private void goToDashboardScreen() {
        Intent intent = new Intent(SplashActivity.this, DashboardActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        finish();
    }
}