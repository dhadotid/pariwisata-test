package com.yudha.myapplication.ui.activity;

import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;

import com.yudha.myapplication.R;
import com.yudha.myapplication.base.BaseActivity;
import com.yudha.myapplication.ui.activity.controller.DetailController;

public class DetailActivity extends BaseActivity {

    ImageView ivImage;
    ImageView ivBack;
    TextView tvTitle;
    TextView tvLocation;
    CardView cardDetaail;
    TextView tvDesc;

    @Override
    public int getLayoutID() {
        return R.layout.activity_detail;
    }

    @Override
    public void initItem() {
        tvDesc = findViewById(R.id.detail_desc);
        ivImage = findViewById(R.id.detail_image);
        ivBack = findViewById(R.id.detail_back);
        tvTitle = findViewById(R.id.detail_title);
        tvLocation = findViewById(R.id.detail_location);
        cardDetaail = findViewById(R.id.detail_cardview);
        new DetailController(this);
    }

    public TextView getTvDesc() {
        return tvDesc;
    }

    public ImageView getIvImage() {
        return ivImage;
    }

    public ImageView getIvBack() {
        return ivBack;
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public TextView getTvLocation() {
        return tvLocation;
    }

    public CardView getCardDetaail() {
        return cardDetaail;
    }
}
