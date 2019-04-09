package vn.edu.httpgreenacademy.vuivc.Network;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentLession extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        APIUI.getLessionService().getLession().enqueue(new Callback<LessionModel>() {
            @Override
            public void onResponse(Call<LessionModel> call, Response<LessionModel> response) {
                if(response.isSuccessful()){
                    LessionModel lessionModel = response.body();
                }
            }

            @Override
            public void onFailure(Call<LessionModel> call, Throwable t) {

            }
        });
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
