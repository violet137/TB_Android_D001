package vn.edu.httpgreenacademy.vuivc;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class FragmentOne extends Fragment {

    private static final String MY_VIDEO_POSITION = "0";
    private static final String MY_VIDEO_NAME = "";
    private static final String MY_VIDEO_URL = "";


    private int mVideoPosition;
    private String mVideoName;
    private String mVideoURL;


    static FragmentOne newInstance(int num,String videoName, String videoURL) {
        FragmentOne f = new FragmentOne();
        Bundle args = new Bundle();
        args.putInt(MY_VIDEO_POSITION, num);
        args.putString(MY_VIDEO_NAME, videoName);
        args.putString(MY_VIDEO_URL, videoURL);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mVideoPosition = getArguments() != null ? getArguments().getInt(MY_VIDEO_POSITION) : 0;
        mVideoName = getArguments() != null ? getArguments().getString(MY_VIDEO_NAME) : "";
        mVideoURL = getArguments() != null ? getArguments().getString(MY_VIDEO_URL) : "";
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_one, container, false);
        TextView tvVideoName = v.findViewById(R.id.tvVideoName);
        final VideoView videoviewVertical = v.findViewById(R.id.videoviewVertical);


        if(!mVideoURL.isEmpty())
        {
            tvVideoName.setText(mVideoName);
            MediaController mediaController = new MediaController(v.getContext());
            mediaController.setAnchorView(videoviewVertical);
            videoviewVertical.setMediaController(mediaController);
            videoviewVertical.setVideoPath(mVideoURL);
            videoviewVertical.setVideoURI(Uri.parse(mVideoURL));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                videoviewVertical.setBackground(videoviewVertical.getBackground());
            }
            videoviewVertical.requestFocus();
            videoviewVertical.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    videoviewVertical.start();
                }
            });
        }
        return v;
    }
}
