package io.github.alexlondon07.finalproject.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import io.github.alexlondon07.finalproject.R;

public class SplashActivity extends AppCompatActivity {

    private LottieAnimationView animationView;
    private final int DURATION_SPLASH = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
        time();
    }

    private void time() {
        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(SplashActivity.this, TourActivity.class);
                startActivity(intent);
                finish();
            };
        }, DURATION_SPLASH);
    }

    private void init() {
        animationView = findViewById(R.id.animation_view);
        animationView.setAnimation("preloader.json");
        animationView.loop(true);
        animationView.playAnimation();
    }


}
