package vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.Adapter.RecycleViewLikedAdapter;
import vn.edu.httpgreenacademy.vuivc.ModelUser.ProfileUser;
import vn.edu.httpgreenacademy.vuivc.R;

public class FragmentLiked extends Fragment {
    RecyclerView recyclerView1;
    ArrayList<ProfileUser> dsAnh = new ArrayList<>();
    RecycleViewLikedAdapter recycleView_liked_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_liked, container, false);
        recyclerView1 = view.findViewById(R.id.recycle_liked);
        recycleView_liked_adapter = new RecycleViewLikedAdapter(dsAnh);
        recyclerView1.setAdapter(recycleView_liked_adapter);
        recyclerView1.setLayoutManager(new GridLayoutManager(getContext(), 3));
        return view;
    }
}
