package vn.edu.httpgreenacademy.vuivc.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import in.myinnos.gifimages.model.Gif;
import vn.edu.httpgreenacademy.vuivc.ModelUser.ProfileUser;
import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.ViewHolder.RecycleViewVideosViewHolder;

public class RecycleviewVideosAdapter extends RecyclerView.Adapter<RecycleViewVideosViewHolder> {
    private final List<Gif> gifs;
    private final Activity context;


    public RecycleviewVideosAdapter(Activity context, List<Gif> gifs) {
        this.context = context;
        this.gifs = gifs;
    }

    @NonNull
    @Override
    public RecycleViewVideosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_fragment_videos,viewGroup,false);
        return new RecycleViewVideosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewVideosViewHolder recycleView_photos_viewHolder, int i) {
        recycleView_photos_viewHolder.Bind(gifs.get(i));

    }

    @Override
    public int getItemCount() {
        return gifs.size();
    }

    public void setGifs(List<Gif> gifs) {
        this.gifs.clear();
        this.gifs.addAll(gifs);

        notifyDataSetChanged();
    }
}
