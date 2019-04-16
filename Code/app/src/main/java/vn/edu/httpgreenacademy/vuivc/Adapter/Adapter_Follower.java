package vn.edu.httpgreenacademy.vuivc.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.ModelUser.Followers;
import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.ViewHolder.ViewHolder_Followers;

public class Adapter_Follower extends RecyclerView.Adapter<ViewHolder_Followers> {
    ArrayList<Followers> dsfollowers ;

    public Adapter_Follower(ArrayList<Followers> dsfollowers) {
        this.dsfollowers = dsfollowers;
    }

    @NonNull
    @Override
    public ViewHolder_Followers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ds_followers,parent,false);
        return new ViewHolder_Followers(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_Followers holder, int position) {
        holder.SetData(dsfollowers.get(position));

    }

    @Override
    public int getItemCount() {
        return dsfollowers.size();
    }
}
