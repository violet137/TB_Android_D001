package vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.Constraints;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import vn.edu.httpgreenacademy.vuivc.Fragment.Comment.Comment_Dialog_Fragmment;
import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.Model.VideoModel;
import vn.edu.httpgreenacademy.vuivc.Dialog.VideoShareDialogFragment;

public class FragmentItemVideo extends Fragment {

    private static final String MY_VIDEO_POSITION = "0";
    private static final String MY_VIDEO_NAME = "";
    private static final String MY_VIDEO_URL = "";

    private int mVideoPosition;
    private String mVideoName;
    private String mVideoURL;
    MediaController mediaController;

    static FragmentItemVideo newInstance(int num, VideoModel videoModel) {
        FragmentItemVideo f = new FragmentItemVideo();
        Bundle args = new Bundle();
        args.putInt(MY_VIDEO_POSITION, num);
        args.putString(MY_VIDEO_NAME, videoModel.getVideoName());
        args.putString(MY_VIDEO_URL, videoModel.getVideoUrl());
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
    public View onCreateView(@NonNull final LayoutInflater inflater, final @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_item_video, container, false);
        TextView tvVideoName = v.findViewById(R.id.tvVideoName);
        final VideoView videoviewVertical = v.findViewById(R.id.videoviewVertical);
        ImageView imvMusic = v.findViewById(R.id.imvMusic);
        ImageView imvShare = v.findViewById(R.id.imvShare);
        ImageView imvComment = v.findViewById(R.id.imvComment);

        // Show video caption
        tvVideoName.setText(mVideoName);

        // Show video player
        mediaController = new MediaController(v.getContext());
        //mediaController.setAnchorView(videoviewVertical);
        videoviewVertical.setMediaController(mediaController);
        videoviewVertical.setVideoURI(Uri.parse(mVideoURL));
        videoviewVertical.requestFocus();
        videoviewVertical.seekTo(1);

        if(videoviewVertical.isPlaying())
        {
            // Rotate video music icon
            RotateAnimation rotate = new RotateAnimation(
                    0, 360,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f
            );

            rotate.setDuration(4000);
            rotate.setRepeatCount(Animation.INFINITE);
            imvMusic.startAnimation(rotate);
        }

        videoviewVertical.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View view, MotionEvent motionEvent) {
                videoviewVertical.start();
                return false;
            }
        });



        videoviewVertical.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                FragmentManager fm = getChildFragmentManager();
                VideoShareDialogFragment videoShareDialogFragment = VideoShareDialogFragment.newInstance("",R.layout.fragment_share_video);
                videoShareDialogFragment.show(fm, "");
                return false;
            }
        });

        // Show popup share video
        imvShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getChildFragmentManager();
                VideoShareDialogFragment videoShareDialogFragment = VideoShareDialogFragment.newInstance("",R.layout.fragment_sharesocial_video);
                videoShareDialogFragment.show(fm, "");
            }
        });

        imvComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getChildFragmentManager();
                Comment_Dialog_Fragmment comment_dialog_fragmment = new Comment_Dialog_Fragmment();
                comment_dialog_fragmment.show(fm,"");
            }
        });



        return v;
    }



}
