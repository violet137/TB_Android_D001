package vn.edu.httpgreenacademy.vuivc.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.ModelUser.Following;
import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.ViewHolder.ViewHolder_Following;

public class Adapter_Following extends RecyclerView.Adapter<ViewHolder_Following> {
    ArrayList<Following> dsfollowing ;

    public Adapter_Following(ArrayList<Following> dsfollowing) {
        this.dsfollowing = dsfollowing;
    }

    @NonNull
    @Override
    public ViewHolder_Following onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ds_following,parent,false);
        return new ViewHolder_Following(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_Following holder, int position) {
        holder.SetData(dsfollowing.get(position));

    }

    @Override
    public int getItemCount() {
        return dsfollowing.size();
    }
}
