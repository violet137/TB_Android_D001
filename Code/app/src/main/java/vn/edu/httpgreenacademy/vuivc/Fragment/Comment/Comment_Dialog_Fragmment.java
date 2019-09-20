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


   RecyclerView recyclerViewComment;
    ArrayList<UserModel> userModelArrayList = new ArrayList<>();
    EditText editTextComment;
    TextView tvTotalCommentItem;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view= inflater.inflate(R.layout.comment_fragment,null, false);

        recyclerViewComment = view.findViewById(R.id.recyclerViewComment);
        tvTotalCommentItem = view.findViewById(R.id.tvTotalCommentItem);

        userModelArrayList.clear();
        userModelArrayList.add(new UserModel("Boy handsome","Nụ cười ấy, chết mất thôi",R.drawable.icon_video_avatar));
        userModelArrayList.add(new UserModel("Kênh giao tiếp","Cho xin link nhạc", R.drawable.icon_video_avatar));
        userModelArrayList.add(new UserModel("Nhi","Chất nhất quả đất",R.drawable.icon_video_avatar));
        userModelArrayList.add(new UserModel("Bé Kòi","Dễ thương quá",R.drawable.icon_video_avatar));
        userModelArrayList.add(new UserModel("Thanh niên nghiêm túc","Con nhà người ta chưa bao giờ làm tôi thất vọng",R.drawable.icon_video_avatar));
        userModelArrayList.add(new UserModel("Tiểu hồ ly","Hóng nhiều clip như thế này nữa",R.drawable.icon_video_avatar));
        userModelArrayList.add(new UserModel("user123456789","Cute xỉu",R.drawable.icon_video_avatar));
        userModelArrayList.add(new UserModel("Q.K","Làm sao quay chậm đoạn cuối được ạ",R.drawable.icon_video_avatar));
        userModelArrayList.add(new UserModel("Trần Khánh Ly","Ước gì mình được như cô ấy",R.drawable.icon_video_avatar));
        userModelArrayList.add(new UserModel("Phong","Sáng tạo",R.drawable.icon_video_avatar));
        Comment_RecyclerView_Adapter comment_recyclerView_adapter = new Comment_RecyclerView_Adapter(userModelArrayList);
        recyclerViewComment.setAdapter(comment_recyclerView_adapter);
        recyclerViewComment.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        tvTotalCommentItem.setText("" + userModelArrayList.size() + " bình luận");
        tvTotalCommentItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        builder.setView(view);
        return builder.create();
    }
}
