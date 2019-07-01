package vn.edu.httpgreenacademy.vuivc.Fragment.Comment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.Adapter.VideoShare_Adapter;
import vn.edu.httpgreenacademy.vuivc.Model.VideoShareModel;
import vn.edu.httpgreenacademy.vuivc.R;

public class Comment_Dialog_Fragmment extends DialogFragment {


    ImageView imageViewQuit;
    RecyclerView recyclerView;
    ArrayList<UserModel> userModelArrayList = new ArrayList<>();
    EditText editTextComment;
    TextView tvTotalCommentItem;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

//        final Dialog dialog = new Dialog(getActivity());
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
//        return dialog;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view= inflater.inflate(R.layout.comment_fragment,null, false);

        imageViewQuit = view.findViewById(R.id.imageViewQuit);
        recyclerView= view.findViewById(R.id.recyclerViewComment);
        tvTotalCommentItem = view.findViewById(R.id.tvTotalCommentItem);

        imageViewQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        userModelArrayList.add(new UserModel("Tung","em co biet gi dau",R.drawable.icon_video_avatar));
        userModelArrayList.add(new UserModel("Anh Duy","Server sap roi ae oi", R.drawable.icon_video_avatar));
        userModelArrayList.add(new UserModel("Chi Hong","May chu ban gai lo lieu qua",R.drawable.icon_video_avatar));

        Comment_RecyclerView_Adapter comment_recyclerView_adapter = new Comment_RecyclerView_Adapter(userModelArrayList);
        recyclerView.setAdapter(comment_recyclerView_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        tvTotalCommentItem.setText("" + userModelArrayList.size() + " bình luận");

        builder.setView(view);
        return builder.create();
    }

//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        View view = inflater.inflate(R.layout.comment_fragment,container,false);
//
//        imageViewQuit = view.findViewById(R.id.imageViewQuit);
//        recyclerView= view.findViewById(R.id.recyclerViewComment);
//        tvTotalCommentItem = view.findViewById(R.id.tvTotalCommentItem);
//
//        imageViewQuit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getFragmentManager().popBackStack();
//            }
//        });
//
//        userModelArrayList.add(new UserModel("Tung","em co biet gi dau",R.drawable.icon_video_avatar));
//        userModelArrayList.add(new UserModel("Anh Duy","Server sap roi ae oi", R.drawable.icon_video_avatar));
//        userModelArrayList.add(new UserModel("Chi Hong","May chu ban gai lo lieu qua",R.drawable.icon_video_avatar));
//
//        Comment_RecyclerView_Adapter comment_recyclerView_adapter = new Comment_RecyclerView_Adapter(userModelArrayList);
//        recyclerView.setAdapter(comment_recyclerView_adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
//
//        tvTotalCommentItem.setText("" + userModelArrayList.size() + " bình luận");
//        return view;
//
//    }
}
