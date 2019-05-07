package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import vn.edu.httpgreenacademy.vuivc.Draw.FragmentPickAVUICC;
import vn.edu.httpgreenacademy.vuivc.R;

public class FragmentYeuThich extends Fragment implements View.OnClickListener {
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPargerAdapter PargerAdapter;
    ImageView Bt_YeuThich_back,imgcheanh;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yeuthich, container, false);
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);
        imgcheanh = view.findViewById(R.id.imgCheAnh);
        PargerAdapter = new ViewPargerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(PargerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        Bt_YeuThich_back = view.findViewById(R.id.BT_YeuThich_Back);
        Bt_YeuThich_back.setOnClickListener(this);
        imgcheanh.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.BT_YeuThich_Back: getActivity().onBackPressed();
                break;
            case R.id.imgCheAnh:
                FragmentPickAVUICC fragmentPickAVUICC = new FragmentPickAVUICC();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(android.R.id.content,fragmentPickAVUICC).addToBackStack("s").commit();
                break;
        }
    }
}
