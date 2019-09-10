package vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import vn.edu.httpgreenacademy.vuivc.Api.ApiUtils;
import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.ViewPager.VerticalViewPager;
import vn.edu.httpgreenacademy.vuivc.Model.VideoModel;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerticalVideoFragment extends Fragment {

    ArrayList<VideoModel> listVideo = new ArrayList<VideoModel>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View viewVerticalViewPager = inflater.inflate(R.layout.fragment_verticalvp, container, false);
        final VerticalViewPager verticalviewpager = viewVerticalViewPager.findViewById(R.id.verticalviewpager);

        ApiUtils.GetVideoService().GetVideoTempList().enqueue(new Callback<List<VideoModel>>() {
            @Override
            public void onResponse(Call<List<VideoModel>> call, Response<List<VideoModel>> response) {
                if(response.isSuccessful()){
                    List<VideoModel> list = response.body();
                    if(list != null && list.size() > 0)
                    {
                        listVideo = new ArrayList(list);
                        verticalviewpager.setAdapter(new VerticalPagerAdapter(getFragmentManager(),listVideo));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<VideoModel>> call, Throwable t) {
                Log.d("Error","" + t.getMessage());
            }
        });
            return viewVerticalViewPager;

        }
    }