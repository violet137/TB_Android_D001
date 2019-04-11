package vn.edu.httpgreenacademy.vuivc.UI.Login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import vn.edu.httpgreenacademy.vuivc.Network.ApiUtils;
import vn.edu.httpgreenacademy.vuivc.Network.BaiHoc;
import vn.edu.httpgreenacademy.vuivc.Network.LessionModel;

public class FragmentLession extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ApiUtils.getLessionService().getLession().enqueue(new Callback<LessionModel>() {
            @Override
            public void onResponse(Call<LessionModel> call, Response<LessionModel> response) {
                if(response.isSuccessful()){
                    LessionModel lessionModel=response.body();
                    Gson gson=new Gson();
                    Type listType = new TypeToken<List<BaiHoc>>() {}.getType();
                    List<BaiHoc> listBaiHoc = gson.fromJson(lessionModel.getData(), listType);
                    Log.d("so luong bai hoc","so luong:"+lessionModel.getStatus());
                }
            }

            @Override
            public void onFailure(Call<LessionModel> call, Throwable t) {

            }
        });

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
