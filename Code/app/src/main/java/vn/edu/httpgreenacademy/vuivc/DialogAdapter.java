package vn.edu.httpgreenacademy.vuivc;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.DialogViewHolder> {

    Activity activity;
    static List<DialogViewHolder> dialogViewHolderList;


    public DialogAdapter(List<DialogViewHolder> dialogViewHolderList,Activity activity) {
        this.dialogViewHolderList=dialogViewHolderList;
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
        dialogViewHolderList.add(holder);
    }


    @Override
    public int getItemCount() {
        return dialogViewHolderList.size();
    }
    public void setDialogViewHolderList(List<DialogAdapter.DialogViewHolder> dialogViewHolderList) {
        this.dialogViewHolderList.clear();
        this.dialogViewHolderList.addAll(dialogViewHolderList);

        notifyDataSetChanged();
    }

    public static class DialogViewHolder extends RecyclerView.ViewHolder{
        ImageView imageItem;
        TextView textViewItem;


        public DialogViewHolder(View itemView) {
            super(itemView);

            imageItem=itemView.findViewById(R.id.img_dailog);
            textViewItem=itemView.findViewById(R.id.tv_item);
        }

        public int setData(String name, String string)
        {
            int id = itemView.getResources().getIdentifier("vn.edu.httpgreenacademy.vuivc","drawable", imageItem.getContext().getPackageName());
            imageItem.setImageResource(id);
            textViewItem.setText(string);
            return 0;
        }
    }
}
