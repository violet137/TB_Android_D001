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

    VerticalViewPager verticalviewpager;
    ArrayList<VideoModel> listVideo = new ArrayList<VideoModel>();
    VerticalPagerAdapter verticalPagerAdapter;
    private int mPage;
    private String mTitle;

    public static VerticalVideoFragment newInstance(int page,String title)
    {
        VerticalVideoFragment verticalVideoFragment = new VerticalVideoFragment();
        Bundle arg = new Bundle();
        arg.putInt("page",page);
        arg.putString("title",title);
        verticalVideoFragment.setArguments(arg);

        return verticalVideoFragment;
    }
    public VerticalVideoFragment(){

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt("page", 0);
        mTitle = getArguments().getString("title");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewVerticalViewPager = inflater.inflate(R.layout.fragment_verticalvp, container, false);

        verticalviewpager = viewVerticalViewPager.findViewById(R.id.verticalviewpager);

        ApiUtils.GetVideoService().GetVideoList().enqueue(new Callback<List<VideoModel>>() {
            @Override
            public void onResponse(Call<List<VideoModel>> call, Response<List<VideoModel>> response) {
                if(response.isSuccessful()){
                    List<VideoModel> list = response.body();
                    listVideo = new ArrayList(list);
                    verticalPagerAdapter = new VerticalPagerAdapter(getFragmentManager(),listVideo);
                    verticalviewpager.setAdapter(verticalPagerAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<VideoModel>> call, Throwable t) {
                Log.d("Error","" + t.getMessage());
            }
        });
            return viewVerticalViewPager;

        }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
    }