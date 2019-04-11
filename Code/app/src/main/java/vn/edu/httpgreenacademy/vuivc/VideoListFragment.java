package vn.edu.httpgreenacademy.vuivc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class VideoListFragment extends Fragment {

    RecyclerView recyclerVideo;
    ArrayList<VideoModel> listVideo = new ArrayList<VideoModel>();
    VideoAdapter videoAdapter;
    public int type_video = 0; // 0 : Moi, 1 : Xuhuong, 2: Theo doi
    public int total_video;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        View viewVideoList = inflater.inflate(R.layout.activity_main,container,false);
        recyclerVideo = viewVideoList.findViewById(R.id.recyclerVideo);

        LinearLayoutManager layoutManager = new LinearLayoutManager(container.getContext()) {

            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller smoothScroller = new LinearSmoothScroller(container.getContext()) {

                    private static final float SPEED = 25f;// Change this value (default=25f)

                    @Override
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return SPEED / displayMetrics.densityDpi;
                    }

                };
                smoothScroller.setTargetPosition(position);
                startSmoothScroll(smoothScroller);
            }

        };
        recyclerVideo.setLayoutManager(layoutManager);
        videoAdapter = new VideoAdapter(GetData(),recyclerVideo);
        recyclerVideo.setAdapter(videoAdapter);
        return viewVideoList;
    }

    public ArrayList<VideoModel> GetData()
    {
        listVideo.clear();
        listVideo.add(new VideoModel("Nancy học tiếng mèo kêu","http://cdn13nofree.keeng.net/playnow/mp4/20190211/8BDE21AA601348BE.mp4",VideoTypeEnum.Normal));
        listVideo.add(new VideoModel("Quàng thượng đáng yêu","http://cdn13nofree.keeng.net/uservideo/playnow/mp4/20180927/3427E73326DA4EF8.mp4",VideoTypeEnum.Normal));
        listVideo.add(new VideoModel("DDU-DU DDU-DU - BLACKPINK","http://cdn13nofree.keeng.net/uservideo/playnow/mp4/20190308/02D145BE4BAA4016.mp4",VideoTypeEnum.Normal));
        listVideo.add(new VideoModel("TIKTOK","http://cdn13nofree.keeng.net/uservideo/playnow/mp4/20180619/FB7463.mp4",VideoTypeEnum.Normal));
        listVideo.add(new VideoModel("Những tình huống hài hước trong Liên Quân","http://cdn13nofree.keeng.net/uservideo/playnow/mp4/20181001/8EF727.mp4",VideoTypeEnum.Normal));
        listVideo.add(new VideoModel("Thắng bại tại Liên Quân","http://cdn13nofree.keeng.net/uservideo/playnow/mp4/20190222/9832f3ef86ab47fa8d100075162377fa.mp4",VideoTypeEnum.Normal));
        total_video = listVideo.size();
        return listVideo;
    }

}
