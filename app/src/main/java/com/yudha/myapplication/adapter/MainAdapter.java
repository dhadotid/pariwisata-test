package com.yudha.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yudha.myapplication.R;
import com.yudha.myapplication.adapter.listener.PariwisataListCallBack;
import com.yudha.myapplication.adapter.viewholder.MainViewHolder;
import com.yudha.myapplication.model.BootCampModel;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<BootCampModel> data = new ArrayList<>();
    PariwisataListCallBack listener;

    public MainAdapter(Context context, ArrayList<BootCampModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_main_content, viewGroup, false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
        return new MainViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MainViewHolder)
            ((MainViewHolder) viewHolder).setupToUI(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void onListClicked(PariwisataListCallBack listener){
        this.listener = listener;
    }
}
