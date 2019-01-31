package com.yudha.myapplication.ui.activity.controller;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.yudha.myapplication.helper.Constant;
import com.yudha.myapplication.model.BootCampModel;
import com.yudha.myapplication.ui.activity.DetailActivity;

public class DetailController {

    DetailActivity activity;
    BootCampModel bootCampModel;

    public DetailController(DetailActivity activity) {
        this.activity = activity;
        activity.hideActionBar();

        bootCampModel = activity.getIntent().getParcelableExtra(Constant.KEY_DATA);
        setData();
        setUI();
        openMaps();
    }

    private void setData(){
        RequestOptions options = new RequestOptions();
        options.fitCenter();
        Glide.with(activity)
                .load(bootCampModel.getGambarPariwisata())
                .apply(options)
                .into(activity.getIvImage());
        activity.getTvTitle().setText(bootCampModel.getNamaPariwisata());
        activity.getTvLocation().setText(bootCampModel.getAlamatPariwisata());
        activity.getTvDesc().setText(bootCampModel.getDetailPariwisata());
    }

    private void setUI(){
        activity.getIvBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }

    private void openMaps(){
        activity.getCardDetaail().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+bootCampModel.getAlamatPariwisata());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                activity.startActivity(mapIntent);
            }
        });
    }
}
