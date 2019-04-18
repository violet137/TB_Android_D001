package com.example.restapi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restapi.Network.ApiUtils;
import com.example.restapi.Network.BaiHoc;
import com.example.restapi.Network.LessModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentLogin extends Fragment {
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main,container,false);
        recyclerView = view.findViewById(R.id.recycle);
        ApiUtils.getLessionService().getLession().enqueue(new Callback<LessModel>() {
            @Override
            public void onResponse(Call<LessModel> call, Response<LessModel> response) {
                if(response.isSuccessful())
                {
                    LessModel lessModel=response.body();
                    Gson gson = new Gson();
                    Type listType = new TypeToken<List<BaiHoc>>() {}.getType();
                    List<BaiHoc> dsbaihoc = gson.fromJson(lessModel.getData(),listType);
                    Log.d("DATA:","DATA:"+lessModel.getData());
                    RecycleAdapter recycleAdapter = new RecycleAdapter(dsbaihoc);
                    recyclerView.setAdapter(recycleAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                }
            }

            @Override
            public void onFailure(Call<LessModel> call, Throwable t) {

            }
        });
        return view;
    }
}
