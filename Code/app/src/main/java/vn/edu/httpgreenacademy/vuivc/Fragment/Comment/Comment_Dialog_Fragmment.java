package vn.edu.httpgreenacademy.vuivc.Fragment.Comment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.R;

public class Comment_Dialog_Fragmment extends DialogFragment {


    ImageView imageViewQuit;
    RecyclerView recyclerView;
    ArrayList<UserModel> userModelArrayList = new ArrayList<>();
    EditText editTextComment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.comment_fragment,container,false);

        imageViewQuit = view.findViewById(R.id.imageViewQuit);
        recyclerView= view.findViewById(R.id.recyclerViewComment);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);


        imageViewQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        UserModel user1 = new UserModel("Tung","em co biet gi dau",R.drawable.member_icon);
        userModelArrayList.add(user1);

        UserModel user2 = new UserModel("Anh Duy","Server sap roi ae oi",R.drawable.member_icon);
        userModelArrayList.add(user2);

        UserModel user3 = new UserModel("Chi Hong","May chu ban gai lo lieu qua",R.drawable.member_icon);
        userModelArrayList.add(user3);

        Comment_RecyclerView_Adapter comment_recyclerView_adapter = new Comment_RecyclerView_Adapter(userModelArrayList);
        recyclerView.setAdapter(comment_recyclerView_adapter);
        recyclerView.setLayoutManager(gridLayoutManager);
        return view;

    }
}
