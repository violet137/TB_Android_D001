package vn.edu.httpgreenacademy.vuivc.Fragment.Comment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import vn.edu.httpgreenacademy.vuivc.R;

public class Comment_RecyclerView_Holder extends RecyclerView.ViewHolder {

//    RecyclerView recyclerViewComment;
//    EditText editTextComment;

   ImageView imageViewUserAvatar;
   TextView textViewUserName;
   TextView textViewUserComment;
   View itemView;

    public Comment_RecyclerView_Holder(@NonNull View itemView) {
        super(itemView);

        this.itemView = itemView;

        imageViewUserAvatar = itemView.findViewById(R.id.imageViewUserAvatar);
        textViewUserName = itemView.findViewById(R.id.textViewUserName);
        textViewUserComment = itemView.findViewById(R.id.textViewUserComment);
    }

    public void setData (UserModel userModel){

        imageViewUserAvatar.setImageResource(R.drawable.ic_launcher_background);
        textViewUserName.setText(userModel.getUserName());
        textViewUserComment.setText(userModel.getUserComment());

    }
}
