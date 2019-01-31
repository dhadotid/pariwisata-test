package com.yudha.myapplication.connection;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.yudha.myapplication.connection.listener.PariwisataCallBack;
import com.yudha.myapplication.helper.Constant;
import com.yudha.myapplication.model.BootCampModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetDataRequest {

    Context context;
    StringRequest stringRequest;
    RequestQueue requestQueue;

    public GetDataRequest(Context context) {
        this.context = context;

        requestQueue = Volley.newRequestQueue(context);
    }

    public void onRequestBootcamp(final PariwisataCallBack listener){
        final ArrayList<BootCampModel> bootCampModels = new ArrayList<>();
        stringRequest = new StringRequest(Request.Method.GET, Constant.index + Constant.bootcamp, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    if (jsonResponse.getString("result").equalsIgnoreCase("true")){
                        JSONArray jsonArray = jsonResponse.getJSONArray("data");
                        if (jsonArray.length()>0){
                            for (int i = 0; i < jsonArray.length(); i++){
                                JSONObject objectData = jsonArray.getJSONObject(i);
                                bootCampModels.add(new BootCampModel(objectData.getString("nama_pariwisata"),
                                        objectData.getString("alamat_pariwisata"), objectData.getString("detail_pariwisata"),
                                        objectData.getString("gambar_pariwisata")));
                            }
                            listener.onRequestCallBack(bootCampModels);
                        }else {
                            listener.onDataIsEmpty();
                        }
                    }else {
                        listener.onDataIsEmpty();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String errorMessage = "";

                if (error instanceof TimeoutError) {
                    errorMessage = "Timeout. Check your connection";
                } else if (error instanceof NoConnectionError) {
                    errorMessage = "Please turn on your connectivity";
                } else if (error instanceof AuthFailureError) {
                    errorMessage = "Authentication error";
                } else if (error instanceof ServerError) {
                    errorMessage = "Server error";
                } else if (error instanceof NetworkError) {
                    errorMessage = "Network Error";
                } else if (error instanceof ParseError) {
                    errorMessage = "Parse Error";
                }
                listener.onRequestError(errorMessage);
            }
        });
        requestQueue.add(stringRequest);
    }
}
