package com.example.profileuser;


import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import com.example.profileuser.Adapter.ViewPagerAdapter;
import com.example.profileuser.Model.ProfileUser;
import com.example.profileuser.databinding.FragmentProfileuserMainBinding;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    ImageButton imgbtn_setting;
    ProfileUser profileUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentProfileuserMainBinding fragmentProfileuserMainBinding = DataBindingUtil.setContentView(this,R.layout.fragment_profileuser_main);
        profileUser = new ProfileUser();
        profileUser.setId(1);
        profileUser.setNameUser("aaa");
        profileUser.setNumVideo(1);
        profileUser.setNumFollower(2);
        profileUser.setNumFollowing(3);
        fragmentProfileuserMainBinding.setUser(profileUser);
        viewPager = findViewById(R.id.vp);
        imgbtn_setting = findViewById(R.id.imgbtn_setting);
        tabLayout = findViewById(R.id.tabLayout);
        ViewPagerAdapter viewPager_adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPager_adapter);
        tabLayout.setupWithViewPager(viewPager);
        imgbtn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,imgbtn_setting);
                popupMenu.getMenuInflater().inflate(R.menu.menu_setting,popupMenu.getMenu());
                popupMenu.show();
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate_button_setting);
                imgbtn_setting.startAnimation(animation);
            }
        });

    }

}
