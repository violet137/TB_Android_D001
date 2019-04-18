package vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import vn.edu.httpgreenacademy.vuivc.Adapter.RecycleviewVideosAdapter;
import vn.edu.httpgreenacademy.vuivc.R;
import in.myinnos.gifimages.GiphyTask;
import in.myinnos.gifimages.builder.GiphyQueryBuilder;
import in.myinnos.gifimages.helper.Helper;
import in.myinnos.gifimages.model.Gif;
import vn.edu.httpgreenacademy.vuivc.ViewHolder.RecycleViewVideosViewHolder;

public class FragmentVideos extends Fragment {
    RecyclerView recyclerView;
    RecycleviewVideosAdapter recycleView_video_adapter;
    public int soluongvideo;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_videos, container, false);

        recyclerView = view.findViewById(R.id.recycle_photo);
        recycleView_video_adapter = new RecycleviewVideosAdapter(getActivity(),new ArrayList<Gif>());
        recyclerView.setAdapter(recycleView_video_adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));



        recyclerView.setRecyclerListener(new RecyclerView.RecyclerListener() {
            @Override
            public void onViewRecycled(RecyclerView.ViewHolder holder) {
                RecycleViewVideosViewHolder gifHolder = (RecycleViewVideosViewHolder) holder;
                gifHolder.stopPlayback();
            }
        });

        return view;
    }



    @Override
    public void onResume() {
        super.onResume();
        new GiphyTask(Helper.getGiphyQueryUrl("pawan kalyan",
                100, GiphyQueryBuilder.EndPoint.SEARCH, ""), new GiphyTask.Callback() {
            @Override
            public void onResponse(List<Gif> gifs) {
                recycleView_video_adapter.setGifs(gifs);
            }
        }).execute();
    }
}
