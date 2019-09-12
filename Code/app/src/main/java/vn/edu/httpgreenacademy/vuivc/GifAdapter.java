package vn.edu.httpgreenacademy.vuivc;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class GifAdapter extends RecyclerView.Adapter<GifViewHolder> {
    static Activity activity;

    static List<Gif> gifs;

    public GifAdapter(Activity activity, List<Gif> gifs) {
        this.activity = activity;
        this.gifs = gifs;
    }

    @NonNull
    @Override
    public GifViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_gif, parent, false);
        return new GifViewHolder(v, activity);
    }

    @Override
    public void onBindViewHolder(@NonNull GifViewHolder holder, final int position) {
        holder.bind(gifs.get(position));
        holder.imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gifs.remove(position);
                notifyDataSetChanged();
            }
        });
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
