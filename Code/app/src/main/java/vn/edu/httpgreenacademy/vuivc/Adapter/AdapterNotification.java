package vn.edu.httpgreenacademy.vuivc.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.Model.NotificationModel;
import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.ViewHolder.NotificationViewHolder;

public class AdapterNotification extends RecyclerView.Adapter<NotificationViewHolder>
{

    ArrayList<NotificationModel> notificationModelArrayList = new ArrayList<>();
    public AdapterNotification(ArrayList<NotificationModel> notificationModelArrayList) {
        this.notificationModelArrayList = notificationModelArrayList;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new NotificationViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_item_notification,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder notificationViewHolder, int i) {
        notificationViewHolder.SetData(notificationModelArrayList.get(i));
    }

    @Override
    public int getItemCount() {
        return notificationModelArrayList.size();
    }
}
