package com.example.asshoanthien.retrofit_nangcao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asshoanthien.retrofit_nangcao.R;
import com.example.asshoanthien.retrofit_nangcao.model.Example;

import java.util.List;

public class CateAdapter extends RecyclerView.Adapter<CateHolder> {
    private Context context;
    private List<Example> cateList;

    public CateAdapter(Context context, List<Example> cateList) {
        this.context = context;
        this.cateList = cateList;
    }

    @NonNull
    @Override
    public CateHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.cate,parent,false);

        return new CateHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CateHolder holder, int position) {
        Example category= cateList.get(position);
        holder.tvContent.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        return cateList.size();
    }

}
