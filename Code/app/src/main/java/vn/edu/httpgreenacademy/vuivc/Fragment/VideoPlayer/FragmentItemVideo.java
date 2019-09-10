package vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import pl.droidsonroids.gif.GifImageView;
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

    private VideoModel videoModelItem;

    static FragmentItemVideo newInstance(VideoModel videoModel, int position) {
        FragmentItemVideo f = new FragmentItemVideo();
        f.videoModelItem = videoModel;
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, final @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_item_video, container, false);
        TextView tvVideoName = v.findViewById(R.id.tvVideoName);
        //ImageView imgViewVideoItem = v.findViewById(R.id.imgViewVideoItem);
        ImageView imvShare = v.findViewById(R.id.imvShare);
        ImageView imvComment = v.findViewById(R.id.imvComment);
        final TextView tvUploaderName = v.findViewById(R.id.tvUploaderName);
        ImageView imvAvatarUpload = v.findViewById(R.id.imvAvatarUpload);
        final GifImageView gifImgViewVideoItem = v.findViewById(R.id.gifImgViewVideoItem);

        final String getVideoName = videoModelItem.getVideoName();
        String getVideoImageURL = videoModelItem.getImageUrl();
        final String getVideoURL = videoModelItem.getVideoUrl();
        int getVideoUploaderId = videoModelItem.getVideoUploaderId();

        // Show video caption
        new DownLoadImageTask(gifImgViewVideoItem).execute(getVideoImageURL);


        // Show popup video viewrget = new GlideDrawableImageViewTarget(imageViewTarget);
        gifImgViewVideoItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse(getVideoURL);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setDataAndType(uri, "video/mp4");
                startActivity(intent);
            }
        });

        // Show popup share video
        imvShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getChildFragmentManager();
                VideoShareDialogFragment videoShareDialogFragment = VideoShareDialogFragment.newInstance("Share video with",
                        R.layout.fragment_sharesocial_video,getVideoURL,getVideoName);
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

        imvAvatarUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        // Show video uploader
        ApiUtils.GetVideoService().GetProfileUser(getVideoUploaderId).enqueue(new Callback<ProfileUser>() {
            @Override
            public void onResponse(Call<ProfileUser> call, Response<ProfileUser> response) {
                if(response.isSuccessful()){
                    ProfileUser user = response.body();
                    tvUploaderName.setText(user.getNameUser());
                }
            }

            @Override
            public void onFailure(Call<ProfileUser> call, Throwable t) {
                Log.d("Error","" + t.getMessage());
            }
        });

        return v;
    }



}
