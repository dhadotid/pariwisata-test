package com.yudha.myapplication.ui.activity.controller;

import android.content.Intent;
import android.os.Handler;

import com.yudha.myapplication.ui.activity.MainActivity;
import com.yudha.myapplication.ui.activity.SplashScreenActivity;

public class SplashScreenController {

    private SplashScreenActivity activity;

    public SplashScreenController(SplashScreenActivity activity) {
        this.activity = activity;
        activity.hideActionBar();
        onSplashCount();
    }

    private void onSplashCount(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                activity.startActivity(new Intent(activity, MainActivity.class));
                activity.finish();
            }
        }, 3000);
    }
}
