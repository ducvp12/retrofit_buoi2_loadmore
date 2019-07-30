package com.example.asshoanthien.retrofit_nangcao.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.asshoanthien.retrofit_nangcao.R;

class CateHolder extends RecyclerView.ViewHolder {
    public TextView tvContent;


    public CateHolder(View view) {
        super(view);
        tvContent=view.findViewById(R.id.tvContent);
    }
}
