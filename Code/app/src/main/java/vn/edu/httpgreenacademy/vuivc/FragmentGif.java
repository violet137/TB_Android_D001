package vn.edu.httpgreenacademy.vuivc;

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

public class FragmentGif extends Fragment {

    RecyclerView recyclerView;
    GifAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_layout,container,false);
        recyclerView=view.findViewById(R.id.recyclerView_gif);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));



                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new GifAdapter(getActivity(), new ArrayList<Gif>());
                        recyclerView.setAdapter(adapter);
                        new GiphyTask(Helper.getGiphyQueryUrl("dragon",
                                20, GiphyQueryBuilder.EndPoint.SEARCH, ""), new GiphyTask.Callback() {
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
