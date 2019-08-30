package vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.Constraints;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.httpgreenacademy.vuivc.Api.ApiUtils;
import vn.edu.httpgreenacademy.vuivc.Fragment.Comment.Comment_Dialog_Fragmment;
import vn.edu.httpgreenacademy.vuivc.ModelUser.ProfileUser;
import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.Model.VideoModel;
import vn.edu.httpgreenacademy.vuivc.Dialog.VideoShareDialogFragment;

public class FragmentItemVideo extends Fragment {

    private static  String MY_VIDEO_POSITION = "0";
    private static  String MY_VIDEO_NAME = "";
    private static  String MY_VIDEO_UPLOADERID = "0";
    private static  String MY_VIDEO_IMAGE_URL = "";

    private int mVideoPosition;
    private String mVideoName;
    private int mVideoUploaderId;
    private String mVideoImageURL;

    public static VideoModel videoModelItem;

    static FragmentItemVideo newInstance(int num, VideoModel videoModel) {
        videoModelItem = videoModel;
        FragmentItemVideo f = new FragmentItemVideo();
        MY_VIDEO_POSITION = "" + num;
        MY_VIDEO_NAME = videoModel.getVideoName();
        MY_VIDEO_UPLOADERID = "" + videoModel.getVideoUploaderId();
        MY_VIDEO_IMAGE_URL = videoModel.getImageUrl();
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mVideoPosition = Integer.parseInt(MY_VIDEO_POSITION);
        mVideoName = MY_VIDEO_NAME;
        mVideoUploaderId = Integer.parseInt(MY_VIDEO_UPLOADERID);
        mVideoImageURL = MY_VIDEO_IMAGE_URL;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, final @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_item_video, container, false);
        TextView tvVideoName = v.findViewById(R.id.tvVideoName);
        ImageView imgViewVideoItem = v.findViewById(R.id.imgViewVideoItem);
        ImageView imvShare = v.findViewById(R.id.imvShare);
        ImageView imvComment = v.findViewById(R.id.imvComment);
        //final TextView tvUploaderName = v.findViewById(R.id.tvUploaderName);

        // Show video caption
        tvVideoName.setText(mVideoName);

//
//        // Show video uploader
//        ApiUtils.GetVideoService().GetProfileUser(mVideoUploaderId).enqueue(new Callback<ProfileUser>() {
//            @Override
//            public void onResponse(Call<ProfileUser> call, Response<ProfileUser> response) {
//                if(response.isSuccessful()){
//                    ProfileUser user = response.body();
//                    tvUploaderName.setText(user.getNameUser());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ProfileUser> call, Throwable t) {
//                Log.d("Error","" + t.getMessage());
//            }
//        });

        // Show popup share video
        imvShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getChildFragmentManager();
                VideoShareDialogFragment videoShareDialogFragment = VideoShareDialogFragment.newInstance("Share video with",R.layout.fragment_sharesocial_video,"",mVideoName);
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
