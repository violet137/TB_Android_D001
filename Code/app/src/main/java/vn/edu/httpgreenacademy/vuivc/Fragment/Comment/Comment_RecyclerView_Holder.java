package vn.edu.httpgreenacademy.vuivc.Fragment.Comment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import vn.edu.httpgreenacademy.vuivc.R;

public class Comment_RecyclerView_Holder extends RecyclerView.ViewHolder {

   ImageView imageViewUserAvatar;
   TextView textViewUserName;
   TextView textViewUserComment;

    public Comment_RecyclerView_Holder(@NonNull View itemView) {
        super(itemView);
        imageViewUserAvatar = itemView.findViewById(R.id.imageViewUserAvatar);
        textViewUserName = itemView.findViewById(R.id.textViewUserName);
        textViewUserComment = itemView.findViewById(R.id.textViewUserComment);
    }

    public void setData (UserModel userModel){

        textViewUserName.setText(userModel.getUserName());
        textViewUserComment.setText(userModel.getUserComment());
        imageViewUserAvatar.setImageResource(userModel.getUserAvatar());

    }
}
