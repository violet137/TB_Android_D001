package vn.edu.httpgreenacademy.vuivc;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class DialogAdapter extends RecyclerView.Adapter<DialogViewHolder> {

    Activity activity;
    List<DialogItem> dialogItemList;


    public DialogAdapter(List<DialogItem> dialogItemList, Activity activity) {
        this.dialogItemList = dialogItemList;
        this.activity=activity;
    }

    @NonNull
    @Override
    public DialogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(activity).inflate(R.layout.iteam_dialog_share,parent,false);
        return new DialogViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DialogViewHolder holder, int position) {
        holder.bind(dialogItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return dialogItemList.size();
    }
    public void setDialogViewHolderList(List<DialogItem> dialogViewHolderList) {
        this.dialogItemList.clear();
        this.dialogItemList.addAll(dialogViewHolderList);

        notifyDataSetChanged();
    }
}
