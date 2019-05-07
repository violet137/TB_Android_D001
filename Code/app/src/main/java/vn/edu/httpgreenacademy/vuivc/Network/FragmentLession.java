package vn.edu.httpgreenacademy.vuivc.Network;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.httpgreenacademy.vuivc.R;


public class FragmentLession extends Fragment {
    RecyclerView listBaiHoc;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_baihoc,container,false);
        listBaiHoc = view.findViewById(R.id.listBaiHoc);
        listBaiHoc.setLayoutManager(new GridLayoutManager(container.getContext(),2));
        APIUI.getLessionService().getLession().enqueue(new Callback<LessionModel>() {
            @Override
            public void onResponse(Call<LessionModel> call, Response<LessionModel> response) {
                if(response.isSuccessful())
                {
                    LessionModel lessionModel = response.body();
                    Gson gson = new Gson();
                    Type listType = new TypeToken<List<BaiHoc>>(){}.getType();
                    List<BaiHoc> baiHocList = gson.fromJson(lessionModel.getData(),listType);
                    listBaiHoc.setAdapter(new BaiHocAdapter(baiHocList));
                }
            }
            @Override
            public void onFailure(Call<LessionModel> call, Throwable t) {

            }
        });
        return view;
    }
}
