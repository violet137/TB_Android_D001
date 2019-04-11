package com.example.profileuser.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import com.example.profileuser.Adapter.ViewPagerAdapter;
import com.example.profileuser.MainActivity;
import com.example.profileuser.R;

public class FragmentUserMain extends Fragment {
    ViewPager viewPager;
    TabLayout tabLayout;
    ImageButton imgbtn_setting;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profileuser_main,container,false);
        viewPager = view.findViewById(R.id.vp);
        imgbtn_setting = view.findViewById(R.id.imgbtn_setting);
        tabLayout = view.findViewById(R.id.tabLayout);
        ViewPagerAdapter viewPager_adapter = new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(viewPager_adapter);
        tabLayout.setupWithViewPager(viewPager);
        imgbtn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getContext(),imgbtn_setting);
                popupMenu.getMenuInflater().inflate(R.menu.menu_setting,popupMenu.getMenu());
                popupMenu.show();
                Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.rotate_button_setting);
                imgbtn_setting.startAnimation(animation);
            }
        });
        return view;
    }
}
