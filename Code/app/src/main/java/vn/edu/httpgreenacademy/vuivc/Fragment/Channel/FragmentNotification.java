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

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.Adapter.AdapterNotification;
import vn.edu.httpgreenacademy.vuivc.Model.NotificationModel;
import vn.edu.httpgreenacademy.vuivc.R;

public class FragmentNotification extends Fragment {

    RecyclerView recycleViewNotification;
    AdapterNotification adapterNotification;
    ArrayList<NotificationModel> listNotification = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification,container,false);
        recycleViewNotification = view.findViewById(R.id.recycleViewNotification);
        recycleViewNotification.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        adapterNotification = new AdapterNotification(listNotification);
        recycleViewNotification.setAdapter(adapterNotification);
        LoadNotificationList();
        return view;
    }

    public void LoadNotificationList()
    {
        listNotification.clear();
        for(int i = 0; i < 10; i++)
        {
            listNotification.add(new NotificationModel("Administrator","Chào mừng bạn đến với Tiktok","https://imagizer.imageshack.com/v2/299x468q90/r/921/SuNnBA.png"));
        }
        adapterNotification.notifyDataSetChanged();
    }


}
