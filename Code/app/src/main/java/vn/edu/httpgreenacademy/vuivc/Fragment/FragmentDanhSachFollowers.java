package vn.edu.httpgreenacademy.vuivc.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.Adapter.Adapter_Follower;
import vn.edu.httpgreenacademy.vuivc.ModelUser.Followers;
import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.Interface.TruyenDuLieu;

public class FragmentDanhSachFollowers extends Fragment {
    RecyclerView recyclerViewDsFollowers;
    public ArrayList<Followers> dsfollower = new ArrayList<>();
    Adapter_Follower adapter_follower;
    ImageView imgbackfollowers;
    TruyenDuLieu truyenDuLieu;
    public void Truyensoluong(TruyenDuLieu truyenDuLieu){
        this.truyenDuLieu = truyenDuLieu;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ds_followers,container,false);
        recyclerViewDsFollowers = view.findViewById(R.id.recycle_dsfollowers);
        imgbackfollowers = view.findViewById(R.id.img_fm_followerback);
        if(dsfollower.isEmpty()) {
            dsfollower.add(new Followers(1, R.drawable.a, "Nghĩa"));
            dsfollower.add(new Followers(2, R.drawable.b, "Vy"));
            dsfollower.add(new Followers(3, R.drawable.c, "Kim"));
            dsfollower.add(new Followers(4, R.drawable.d, "Long"));
            dsfollower.add(new Followers(5, R.drawable.e, "Trinh"));
        }
        truyenDuLieu.GetSoluongVideo(dsfollower.size());
        adapter_follower = new Adapter_Follower(dsfollower);
        recyclerViewDsFollowers.setAdapter(adapter_follower);
        recyclerViewDsFollowers.setLayoutManager(new LinearLayoutManager(getContext()));
        imgbackfollowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });

        return view;

    }
}
