package vn.edu.httpgreenacademy.vuivc.Fragment.Channel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.Adapter.AdapterDiscovery;
import vn.edu.httpgreenacademy.vuivc.Model.DiscoveryModel;
import vn.edu.httpgreenacademy.vuivc.R;

public class FragmentDiscoveryMonitor extends Fragment {

    TextView tvSearchDiscovery;
    RecyclerView recycleViewDiscoveryFullList;
    ArrayList<DiscoveryModel> listDiscoveryModel = new ArrayList<>();
    AdapterDiscovery adapterDiscovery;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_discovery_list,container,false);
        tvSearchDiscovery = view.findViewById(R.id.tvSearchDiscovery);
        recycleViewDiscoveryFullList = view.findViewById(R.id.recycleViewDiscoveryFullList);
        recycleViewDiscoveryFullList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        adapterDiscovery = new AdapterDiscovery(listDiscoveryModel);
        recycleViewDiscoveryFullList.setAdapter(adapterDiscovery);
        LoadDiscoveryList();
        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void LoadDiscoveryList()
    {
        listDiscoveryModel.clear();
        ArrayList<String> listImageUrl= new ArrayList<String>();
        listImageUrl.add("https://imagizer.imageshack.com/img922/7789/h4NRss.gif");
        listImageUrl.add("https://www.imageshack.us/a/img923/8179/7G0bHe.gif");
        listImageUrl.add("https://imagizer.imageshack.com/img924/9914/vSDet6.gif");
        listImageUrl.add("https://imagizer.imageshack.com/img922/3858/TaylvP.gif");
        listImageUrl.add("https://imagizer.imageshack.com/img924/1253/01xUHi.gif");

        for(int i = 0; i < 10; i++)
        {
            listDiscoveryModel.add(new DiscoveryModel("bansaohoanhao","Hashtag HOT",listImageUrl,new ArrayList<String>()));
        }
        adapterDiscovery.notifyDataSetChanged();
    }

}
