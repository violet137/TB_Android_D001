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

import vn.edu.httpgreenacademy.vuivc.Adapter.AdapterFollowing;
import vn.edu.httpgreenacademy.vuivc.Interface.TruyenDuLieu;
import vn.edu.httpgreenacademy.vuivc.ModelUser.Following;
import vn.edu.httpgreenacademy.vuivc.R;

public class FragmentDanhSachFollowing extends Fragment {
    RecyclerView recyclerViewDsFollowing;
    ArrayList<Following> dsfollowing = new ArrayList<>();
    AdapterFollowing adapter_following;
    ImageView imgbackfollowing;
    TruyenDuLieu truyenDuLieu;
    public void TruyensoluongFollowing(TruyenDuLieu truyenDuLieu){
        this.truyenDuLieu = truyenDuLieu;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_ds_following,container,false);
        imgbackfollowing = view.findViewById(R.id.img_fmfollowing_back);
        recyclerViewDsFollowing = view.findViewById(R.id.recycle_dsfollowing);
        if(dsfollowing.isEmpty()) {
            dsfollowing.add(new Following(1, R.drawable.a, "Nghĩa"));
            dsfollowing.add(new Following(2, R.drawable.b, "Vy"));
            dsfollowing.add(new Following(3, R.drawable.c, "Kim"));
            dsfollowing.add(new Following(4, R.drawable.d, "Long"));
            dsfollowing.add(new Following(5, R.drawable.e, "Trinh"));
        }
        truyenDuLieu.GetSoluongFollowing(dsfollowing.size());
        adapter_following = new AdapterFollowing(dsfollowing);
        recyclerViewDsFollowing.setAdapter(adapter_following);
        recyclerViewDsFollowing.setLayoutManager(new LinearLayoutManager(getActivity()));

        imgbackfollowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });
        return view;
    }
}
