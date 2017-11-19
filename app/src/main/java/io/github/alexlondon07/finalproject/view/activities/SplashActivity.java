package io.github.alexlondon07.finalproject.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import io.github.alexlondon07.finalproject.R;

public class SplashActivity extends AppCompatActivity {

    private LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }

    private void init() {
        animationView = findViewById(R.id.animation_view);
        animationView.setAnimation("lego_loader.json");
        animationView.loop(true);
        animationView.playAnimation();
    }
}
