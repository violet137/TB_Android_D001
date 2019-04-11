package vn.edu.httpgreenacademy.vuivc.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.ModelUser.ProfileUser;
import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.ViewHolder.RecycleViewLikedViewHolder;

public class RecycleViewLikedAdapter extends RecyclerView.Adapter<RecycleViewLikedViewHolder> {
    ArrayList<ProfileUser> dsanhlike = new ArrayList<>();

    public RecycleViewLikedAdapter(ArrayList<ProfileUser> dsanh) {
        this.dsanhlike = dsanh;
    }

    @NonNull
    @Override
    public RecycleViewLikedViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_fragment_liked,viewGroup,false);
        return new RecycleViewLikedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewLikedViewHolder recycleView_liked_viewHolder, int i) {
        recycleView_liked_viewHolder.SetData(dsanhlike.get(i));

    }

    @Override
    public int getItemCount() {
        return dsanhlike.size();
    }
}
