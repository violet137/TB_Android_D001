package vn.edu.httpgreenacademy.vuivc.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.Model.DiscoveryModel;
import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.ViewHolder.DiscoveryViewHolder;
import vn.edu.httpgreenacademy.vuivc.ViewHolder.VideoShare_ViewHolder;

public class AdapterDiscovery extends RecyclerView.Adapter<DiscoveryViewHolder> {

    ArrayList<DiscoveryModel> discoveryModelArrayList = new ArrayList<>();
    public AdapterDiscovery(ArrayList<DiscoveryModel> discoveryModelArrayList) {
        this.discoveryModelArrayList = discoveryModelArrayList;
    }

    @NonNull
    @Override
    public DiscoveryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new DiscoveryViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_item_discovery,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DiscoveryViewHolder discoveryViewHolder, int i) {
         discoveryViewHolder.SetData(discoveryModelArrayList.get(i));
    }

    @Override
    public int getItemCount() {
        return discoveryModelArrayList.size();
    }
}
