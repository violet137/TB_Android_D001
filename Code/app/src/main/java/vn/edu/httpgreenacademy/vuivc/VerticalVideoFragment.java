package vn.edu.httpgreenacademy.vuivc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class VerticalVideoFragment extends Fragment {

    VerticalViewPager verticalviewpager;
    ArrayList<VideoModel> listVideo = new ArrayList<VideoModel>();
    VerticalPagerAdapter verticalPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewVerticalViewPager = inflater.inflate(R.layout.fragment_verticalvp,container,false);

        verticalviewpager = viewVerticalViewPager.findViewById(R.id.verticalviewpager);
        listVideo.clear();
        listVideo.add(new VideoModel("Nancy học tiếng mèo kêu","http://cdn13nofree.keeng.net/playnow/mp4/20190211/8BDE21AA601348BE.mp4",VideoTypeEnum.Normal,1,1,1));
        listVideo.add(new VideoModel("Quàng thượng đáng yêu","http://cdn13nofree.keeng.net/uservideo/playnow/mp4/20180927/3427E73326DA4EF8.mp4",VideoTypeEnum.Normal,1,1,1));
        listVideo.add(new VideoModel("Quàng thượng đáng yêu","http://cdn13nofree.keeng.net/uservideo/playnow/mp4/20180927/3427E73326DA4EF8.mp4",VideoTypeEnum.Normal,1,1,1));
        listVideo.add(new VideoModel("TIKTOK","http://cdn13nofree.keeng.net/uservideo/playnow/mp4/20180619/FB7463.mp4",VideoTypeEnum.Normal,1,1,1));
        listVideo.add(new VideoModel("Những tình huống hài hước trong Liên Quân","http://cdn13nofree.keeng.net/uservideo/playnow/mp4/20181001/8EF727.mp4",VideoTypeEnum.Normal,1,1,1));
        listVideo.add(new VideoModel("Thắng bại tại Liên Quân","http://cdn13nofree.keeng.net/uservideo/playnow/mp4/20190222/9832f3ef86ab47fa8d100075162377fa.mp4",VideoTypeEnum.Normal,1,1,1));
        verticalPagerAdapter = new VerticalPagerAdapter(getFragmentManager(),listVideo);
        verticalviewpager.setAdapter(verticalPagerAdapter);
        return viewVerticalViewPager;
    }
}
