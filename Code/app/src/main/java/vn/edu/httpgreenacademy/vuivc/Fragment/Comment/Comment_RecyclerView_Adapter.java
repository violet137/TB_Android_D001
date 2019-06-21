package vn.edu.httpgreenacademy.vuivc.Fragment.Comment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.R;

public class Comment_RecyclerView_Adapter extends RecyclerView.Adapter<Comment_RecyclerView_Holder> {

    ArrayList<UserModel> userModelArrayList = new ArrayList<>();
    public Comment_RecyclerView_Adapter(ArrayList<UserModel> userModelArrayList) {
        this.userModelArrayList = userModelArrayList;
    }

    @NonNull
    @Override
    public Comment_RecyclerView_Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.comment_item,viewGroup,false);
        return new Comment_RecyclerView_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Comment_RecyclerView_Holder comment_recyclerView_holder, int i) {
         comment_recyclerView_holder.setData(userModelArrayList.get(i));
    }

    @Override
    public int getItemCount() {
        return userModelArrayList.size();
    }
}
