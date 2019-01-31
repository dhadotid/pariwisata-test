package com.yudha.myapplication.connection.listener;

import com.yudha.myapplication.model.BootCampModel;

import java.util.ArrayList;

public interface PariwisataCallBack {
    void onRequestCallBack(ArrayList<BootCampModel> data);
    void onDataIsEmpty();
    void onRequestError(String errorMessage);
}
