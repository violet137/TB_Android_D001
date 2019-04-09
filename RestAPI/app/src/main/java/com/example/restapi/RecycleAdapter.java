package com.example.restapi;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restapi.Network.BaiHoc;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

public class RecycleAdapter extends RecyclerView.Adapter<ViewHolder> {
   List<BaiHoc> arrayList = new ArrayList<>();

    public RecycleAdapter(List<BaiHoc> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycle,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.SetData(arrayList.get(i));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
