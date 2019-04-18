package vn.edu.httpgreenacademy.vuivc;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class ShareDialogFragment extends DialogFragment {

    RecyclerView listA,listB;
    Button bt_cancel;
    DialogAdapter dialogAdapterA,dialogAdapterB;
    List<DialogAdapter.DialogViewHolder> dialogViewHoldersA,dialogViewHoldersB;

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
        dialogViewHoldersA.add(new DialogAdapter.DialogViewHolder(inflater.inflate(R.layout.iteam_dialog_share,null))
                .setData("ic_launcher_background.xml","Home"));
        dialogAdapterA.setDialogViewHolderList(dialogViewHoldersA);
        listA.setAdapter(dialogAdapterA);
        builder.setView(v);
        return builder.create();
    }
}
