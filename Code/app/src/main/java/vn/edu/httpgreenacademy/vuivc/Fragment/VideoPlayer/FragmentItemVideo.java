package vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer;

import android.app.ProgressDialog;
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

    private static  String MY_VIDEO_POSITION = "0";
    private static  String MY_VIDEO_NAME = "";
    private static  String MY_VIDEO_URL = "";

    private int mVideoPosition;
    private String mVideoName;
    private String mVideoURL;
    private ProgressDialog bar;
    MediaController mediaController;

    static FragmentItemVideo newInstance(int num, VideoModel videoModel) {
        FragmentItemVideo f = new FragmentItemVideo();
        MY_VIDEO_POSITION = "" + num;
        MY_VIDEO_NAME = videoModel.getVideoName();
        MY_VIDEO_URL = videoModel.getVideoUrl();
//        Bundle args = new Bundle();
//        args.putInt(MY_VIDEO_POSITION, num);
//        args.putString(MY_VIDEO_NAME, videoModel.getVideoName());
//        args.putString(MY_VIDEO_URL, videoModel.getVideoUrl());
//        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mVideoPosition = getArguments() != null ? getArguments().getInt(MY_VIDEO_POSITION) : 0;
//        mVideoName = getArguments() != null ? getArguments().getString(MY_VIDEO_NAME) : "";
//        mVideoURL = getArguments() != null ? getArguments().getString(MY_VIDEO_URL) : "";
        mVideoPosition = Integer.parseInt(MY_VIDEO_POSITION);
        mVideoName = MY_VIDEO_NAME;
        mVideoURL = MY_VIDEO_URL;
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
        tvVideoName.setSelected(true);
        
        // Show video player
        bar=new ProgressDialog(getActivity());
        bar.setTitle("Connecting server");
        bar.setMessage("Please Wait... ");
        bar.setCancelable(false);
        bar.show();
        if(bar.isShowing()) {
            videoviewVertical.setVideoURI(Uri.parse(mVideoURL));
            mediaController = new MediaController(getActivity());
            mediaController.setMediaPlayer(videoviewVertical);
            videoviewVertical.setMediaController(mediaController);
            videoviewVertical.requestFocus();
        }
        bar.dismiss();

        // Rotate video music icon
        RotateAnimation rotate = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        rotate.setDuration(4000);
        rotate.setRepeatCount(Animation.INFINITE);
        imvMusic.startAnimation(rotate);

        // Show popup share video
        imvShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getChildFragmentManager();
                VideoShareDialogFragment videoShareDialogFragment = VideoShareDialogFragment.newInstance("Share video with",R.layout.fragment_sharesocial_video,mVideoURL,mVideoName);
                videoShareDialogFragment.show(fm, "Share video with");
            }
        });

        imvComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getChildFragmentManager();
                Comment_Dialog_Fragmment comment_dialog_fragmment = new Comment_Dialog_Fragmment();
                comment_dialog_fragmment.show(fm,"Show video comment");
            }
        });



        return v;
    }



}
