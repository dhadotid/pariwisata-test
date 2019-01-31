package com.yudha.myapplication.ui.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;

import com.yudha.myapplication.R;
import com.yudha.myapplication.base.BaseActivity;
import com.yudha.myapplication.ui.activity.controller.MainController;

public class MainActivity extends BaseActivity {

    RecyclerView listContent;
    FloatingActionButton btnLogin;
    MainController controller;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initItem() {
        listContent = findViewById(R.id.main_recyclerview);
        btnLogin = findViewById(R.id.main_login);
        controller = new MainController(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        controller.onActivityResult(requestCode, resultCode, data);
    }

    public FloatingActionButton getBtnLogin() {
        return btnLogin;
    }

    public RecyclerView getListContent() {
        return listContent;
    }
}
