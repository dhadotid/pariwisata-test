package com.yudha.myapplication.ui.activity;

import com.yudha.myapplication.R;
import com.yudha.myapplication.base.BaseActivity;
import com.yudha.myapplication.ui.activity.controller.SplashScreenController;

public class SplashScreenActivity extends BaseActivity {

    @Override
    public int getLayoutID() {
        return R.layout.activity_splash_screen;
    }

    @Override
    public void initItem() {
        new SplashScreenController(this);
    }
}
