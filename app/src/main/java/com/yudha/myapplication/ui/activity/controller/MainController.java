package com.yudha.myapplication.ui.activity.controller;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.yudha.myapplication.adapter.MainAdapter;
import com.yudha.myapplication.adapter.listener.PariwisataListCallBack;
import com.yudha.myapplication.connection.GetDataRequest;
import com.yudha.myapplication.connection.listener.PariwisataCallBack;
import com.yudha.myapplication.helper.Constant;
import com.yudha.myapplication.model.BootCampModel;
import com.yudha.myapplication.ui.activity.DetailActivity;
import com.yudha.myapplication.ui.activity.LoginActivity;
import com.yudha.myapplication.ui.activity.MainActivity;

import java.util.ArrayList;

public class MainController {

    private MainActivity activity;
    private MainAdapter adapter;
    private ArrayList<BootCampModel> data = new ArrayList<>();
    private GoogleSignInAccount account;
    public MainController(MainActivity activity) {
        this.activity = activity;
        activity.hideActionBar();
        setUpUI();
        setAdapter();
        onRequestData();
        onButtonLoginClicked();
    }

    private void setUpUI(){
        account = GoogleSignIn.getLastSignedInAccount(activity);
        if (account!=null)
            activity.getBtnLogin().hide();
    }

    private void setAdapter(){
        adapter = new MainAdapter(activity, data);
        adapter.onListClicked(new PariwisataListCallBack() {
            @Override
            public void onClicked(BootCampModel bootCampModel) {
                Intent intent = new Intent(activity, DetailActivity.class);
                intent.putExtra(Constant.KEY_DATA, bootCampModel);
                activity.startActivity(intent);
            }
        });
        activity.getListContent().setItemAnimator(new DefaultItemAnimator());
        activity.getListContent().setLayoutManager(new GridLayoutManager(activity, 2));
        activity.getListContent().setAdapter(adapter);
    }

    private void onRequestData(){
        new GetDataRequest(activity).onRequestBootcamp(new PariwisataCallBack() {
            @Override
            public void onRequestCallBack(ArrayList<BootCampModel> datas) {
                data.addAll(datas);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onDataIsEmpty() {
                activity.showToast("Data Not Found!");
            }

            @Override
            public void onRequestError(String errorMessage) {
                activity.showToast(errorMessage);
            }
        });
    }

    private void onButtonLoginClicked(){
        activity.getBtnLogin().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, LoginActivity.class);
                activity.startActivityForResult(intent, Constant.REQUEST_LOGIN);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == activity.RESULT_OK){
            if (requestCode == Constant.REQUEST_LOGIN){
                activity.getBtnLogin().hide();
                activity.showToast("Welcome " + data.getStringExtra(Constant.KEY_DATA));
            }
        }
    }
}
