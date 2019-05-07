package vn.edu.httpgreenacademy.vuivc.Dialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import vn.edu.httpgreenacademy.vuivc.R;

public class VideoShareDialogFragment extends DialogFragment {

    public static int resourceLayout;

    public static VideoShareDialogFragment newInstance(String data,int resource_Layout) {
        VideoShareDialogFragment dialog = new VideoShareDialogFragment();
        Bundle args = new Bundle();
        args.putString("data", data);
        dialog.setArguments(args);
       resourceLayout = resource_Layout;
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(resourceLayout, null);

        Dialog dialog = new Dialog(getContext(), R.style.ThemeOverlay_AppCompat_Dialog);
        dialog.setContentView(view);
        return dialog;
    }

//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        View dialogView = inflater.inflate(resourceLayout, container,false);
//
//        TextView tvShareMore = dialogView.findViewById(R.id.tvShareMore);
//        tvShareMore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent share = new Intent(Intent.ACTION_SENDTO);
//                share.setType("text/plain");
//                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
//                share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
//                share.putExtra(Intent.EXTRA_TEXT, "http://cdn13nofree.keeng.net/playnow/mp4/20190211/8BDE21AA601348BE.mp4");
//                startActivity(Intent.createChooser(share, "Share link!"));
//            }
//        });
//        return dialogView;
//    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
