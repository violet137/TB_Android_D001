package vn.edu.httpgreenacademy.vuivc.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.ViewHolder.DiscoveryImageViewHolder;
import vn.edu.httpgreenacademy.vuivc.ViewHolder.DiscoveryViewHolder;

public class AdapterDiscoveryImage extends RecyclerView.Adapter<DiscoveryImageViewHolder> {

    ArrayList<String> listImageUrl = new ArrayList<>();
    public AdapterDiscoveryImage(ArrayList<String> listImageUrl) {
        this.listImageUrl = listImageUrl;
    }

    @NonNull
    @Override
    public DiscoveryImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new DiscoveryImageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_item_discovery_image,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DiscoveryImageViewHolder discoveryImageViewHolder, int i) {
        discoveryImageViewHolder.SetData(listImageUrl.get(i));
    }

    @Override
    public int getItemCount() {
        return listImageUrl.size();
    }
}
