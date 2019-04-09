package com.example.profileuser;


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

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    ImageButton imgbtn_setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profileuser_main);
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
