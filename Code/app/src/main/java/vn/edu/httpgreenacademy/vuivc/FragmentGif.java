package vn.edu.httpgreenacademy.vuivc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentGif extends Fragment {

    RecyclerView recyclerView;
    GifAdapter adapter;
    private static FragmentGif fragmentGif;

    int mNum;

    public FragmentGif() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_layout,container,false);
        recyclerView=view.findViewById(R.id.recyclerView_gif);
        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);



                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new GifAdapter(getActivity(), new ArrayList<Gif>());
                        recyclerView.setAdapter(adapter);
                        new GiphyTask(Helper.getGiphyQueryUrl("",
                                5, GiphyQueryBuilder.EndPoint.TRENDS, ""), new GiphyTask.Callback() {
                            @Override
                            public void onResponse(List<Gif> gifs) {
                                adapter.setGifs(gifs);
                            }
                        }).execute();
                    }
                });
                thread.run();

        recyclerView.setRecyclerListener(new RecyclerView.RecyclerListener() {
            @Override
            public void onViewRecycled(RecyclerView.ViewHolder holder) {
                GifViewHolder gifHolder = (GifViewHolder) holder;
                gifHolder.stopPlayback();
            }
        });
        return view;
    }



}
