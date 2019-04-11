package vn.edu.httpgreenacademy.vuivc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class VideoPagerFragment extends Fragment {

    ViewPager viewPagerVideo;
    TabLayout tabLayoutVideo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View viewVideoPager = inflater.inflate(R.layout.fragment_video_pager,container,false);
        viewPagerVideo = viewVideoPager.findViewById(R.id.viewPagerVideo);
        tabLayoutVideo = viewVideoPager.findViewById(R.id.tabLayoutVideo);
        viewPagerVideo.setAdapter(new ViewPagerAdapter(getFragmentManager()));
        tabLayoutVideo.setupWithViewPager(viewPagerVideo);
        return viewVideoPager;
    }
}
