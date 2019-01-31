package com.yudha.myapplication.adapter.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.yudha.myapplication.R;
import com.yudha.myapplication.adapter.listener.PariwisataListCallBack;
import com.yudha.myapplication.model.BootCampModel;

public class MainViewHolder extends RecyclerView.ViewHolder {

    View view;
    ImageView image;
    TextView tvTitle;
    TextView tvDesc;
    CardView mainCard;
    PariwisataListCallBack listener;

    public MainViewHolder(View view, PariwisataListCallBack listener){
        super(view);
        this.view = view;
        this.listener = listener;
        image = view.findViewById(R.id.custom_main_content_image);
        mainCard = view.findViewById(R.id.main_card);
        tvTitle = view.findViewById(R.id.custom_main_content_title);
        tvDesc = view.findViewById(R.id.custom_main_content_desc);
    }

    public void setupToUI(final BootCampModel data){
        RequestOptions options = new RequestOptions();
        options.fitCenter();
        Glide.with(view.getContext())
                .load(data.getGambarPariwisata())
                .apply(options)
                .into(image);
        tvTitle.setText(data.getNamaPariwisata());
//        tvDesc.setText(data.getDetailPariwisata());
        tvDesc.setEllipsize(TextUtils.TruncateAt.END);
        tvDesc.setMaxLines(3);
        tvDesc.setText(data.getDetailPariwisata());
        tvDesc.setVisibility(View.VISIBLE);

        mainCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClicked(data);
            }
        });
    }

}
