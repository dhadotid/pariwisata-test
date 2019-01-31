package com.yudha.myapplication.ui.activity.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.yudha.myapplication.helper.Constant;
import com.yudha.myapplication.ui.activity.LoginActivity;

public class LoginController {

    LoginActivity activity;
    GoogleSignInAccount account;

    public LoginController(LoginActivity activity) {
        this.activity = activity;
        setUpUI();
    }

    private void setUpUI(){
        activity.hideActionBar();
        activity.getBtnLogin().setSize(SignInButton.SIZE_STANDARD);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        final GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(activity, gso);
//        account = GoogleSignIn.getLastSignedInAccount(activity);
//        detailInformation(account);

        activity.getBtnLogin().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = googleSignInClient.getSignInIntent();
                activity.startActivityForResult(signInIntent, Constant.REQUEST_CODE);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == activity.RESULT_OK){
            if (requestCode == Constant.REQUEST_CODE){
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                handleSignIn(task);
            }
        }
    }

    private void handleSignIn(Task<GoogleSignInAccount> completedTask){
        try {
            account = completedTask.getResult(ApiException.class);
            detailInformation(account);
        }catch (Exception e){

        }
    }

    private void detailInformation (GoogleSignInAccount account){
        Intent intent = activity.getIntent();
        intent.putExtra(Constant.KEY_DATA, account.getDisplayName()+"");
        activity.setResult(activity.RESULT_OK, intent);
        activity.finish();
    }
}
