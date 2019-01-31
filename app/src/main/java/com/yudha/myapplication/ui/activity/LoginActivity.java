package com.yudha.myapplication.ui.activity;

import android.content.Intent;
import android.support.annotation.Nullable;

import com.google.android.gms.common.SignInButton;
import com.yudha.myapplication.R;
import com.yudha.myapplication.base.BaseActivity;
import com.yudha.myapplication.ui.activity.controller.LoginController;

public class LoginActivity extends BaseActivity {

    SignInButton btnLogin;
    LoginController controller;

    @Override
    public int getLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    public void initItem() {
        btnLogin = findViewById(R.id.login_google);
        controller = new LoginController(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        controller.onActivityResult(requestCode, resultCode, data);
    }

    public SignInButton getBtnLogin() {
        return btnLogin;
    }
}
