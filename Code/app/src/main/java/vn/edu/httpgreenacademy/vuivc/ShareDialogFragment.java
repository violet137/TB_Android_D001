package vn.edu.httpgreenacademy.vuivc;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ShareDialogFragment extends DialogFragment {

    RecyclerView listA,listB;
    Button bt_cancel;
    DialogAdapter dialogAdapterA,dialogAdapterB;
    ArrayList<DialogItem> dialogItemListA, dialogItemListB;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View v= inflater.inflate(R.layout.dialog_share,null);
        listA=v.findViewById(R.id.recyclerView_share_a);
        listB=v.findViewById(R.id.recyclerView_share_b);
        bt_cancel=v.findViewById(R.id.bt_cancel);
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareDialogFragment.this.getDialog().cancel();
            }
        });

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                dialogItemListA = new ArrayList<>();
                dialogAdapterA=new DialogAdapter(dialogItemListA,getActivity());

                dialogItemListA.add(new DialogItem("tinnhan","Tin nhắn"));
                dialogItemListA.add(new DialogItem("fb","Facebook"));
                dialogItemListA.add(new DialogItem("mess","Messenger"));
                dialogItemListA.add(new DialogItem("zalo","Zalo"));
                dialogItemListA.add(new DialogItem("twitter","Twitter"));
                dialogItemListA.add(new DialogItem("ins","Instagram"));
                dialogItemListA.add(new DialogItem("stories","Stories"));
                dialogItemListA.add(new DialogItem("sms","SMS"));
                dialogItemListA.add(new DialogItem("email","Email"));
                dialogItemListA.add(new DialogItem("lienket","Sao chép\nLiên kết"));
                dialogItemListA.add(new DialogItem("khac","Khác"));

                listA.setAdapter(dialogAdapterA);
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                dialogItemListB = new ArrayList<>();
                dialogAdapterB = new DialogAdapter(dialogItemListB,getActivity());

                dialogItemListB.add(new DialogItem("duet","Duet"));
                dialogItemListB.add(new DialogItem("react","React"));
                dialogItemListB.add(new DialogItem("down","Lưu video"));
                dialogItemListB.add(new DialogItem("gif","Chia sẻ dưới\ndạng GIF"));
                dialogItemListB.add(new DialogItem("love","Thêm vào\nƯu thích"));
                dialogItemListB.add(new DialogItem("not","Không\nQuan tâm"));
                dialogItemListB.add(new DialogItem("problem","Báo cáo"));
                dialogItemListB.add(new DialogItem("live","Live Photo"));
                listB.setAdapter(dialogAdapterB);
            }
        });
        thread1.run();
        thread2.run();

        builder.setView(v);
        return builder.create();
    }
}
