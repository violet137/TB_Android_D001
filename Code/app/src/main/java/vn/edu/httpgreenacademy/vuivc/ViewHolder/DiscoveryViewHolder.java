package vn.edu.httpgreenacademy.vuivc.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.Adapter.AdapterDiscoveryImage;
import vn.edu.httpgreenacademy.vuivc.Model.DiscoveryModel;
import vn.edu.httpgreenacademy.vuivc.R;

public class DiscoveryViewHolder extends RecyclerView.ViewHolder {

    View currentView;
    TextView tvdiscoveryTitle, tvdiscoveryHashtag;
    RecyclerView recylerViewDiscoveryList;

    public DiscoveryViewHolder(@NonNull View itemView) {
        super(itemView);
        currentView = itemView;
        tvdiscoveryTitle = itemView.findViewById(R.id.tvdiscoveryTitle);
        tvdiscoveryHashtag = itemView.findViewById(R.id.tvdiscoveryHashtag);
        recylerViewDiscoveryList = itemView.findViewById(R.id.recylerViewDiscoveryList);
    }

    public void SetData(DiscoveryModel model)
    {
        tvdiscoveryTitle.setText(model.getTitle());
        tvdiscoveryHashtag.setText(model.getHashtag());
        ArrayList<String> listImageUrl = model.getListImageUrl();
        if(listImageUrl != null && listImageUrl.size() > 0)
        {
            recylerViewDiscoveryList.setLayoutManager(new LinearLayoutManager(currentView.getContext(), LinearLayoutManager.HORIZONTAL,false));
            recylerViewDiscoveryList.setAdapter(new AdapterDiscoveryImage(listImageUrl));
        }
    }
}
