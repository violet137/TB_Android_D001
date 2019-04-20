package vn.edu.httpgreenacademy.vuivc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class GifViewHolder extends RecyclerView.ViewHolder {
    Activity activity;

    ImageView previewImage;
    GifView gifView;
    ImageView imgLike,imgDisLike,imgCommnent,imgShare;
    TextView tvLike,tvDisLike,tvComment,tvShare;
    int intLike,intDislike,intComment,intShare;
    boolean isBleanLike,isBleanDisLike,isBleanComment,isBleanShare;
    TextView tvId;
    TextView tvCaption;
    ImageView imgClose;
    boolean isBleanClose;

    GifViewHolder(View itemView, Activity activity) {
        super(itemView);

        this.activity = activity;

        previewImage = itemView.findViewById(R.id.preview_image_gif_item);
        gifView = itemView.findViewById(R.id.gif_view_item);
        imgLike=itemView.findViewById(R.id.img_like);
        imgDisLike=itemView.findViewById(R.id.img_dislike);
        imgCommnent=itemView.findViewById(R.id.img_comment);
        imgShare=itemView.findViewById(R.id.img_share);
        tvComment=itemView.findViewById(R.id.tv_comment);
        tvDisLike=itemView.findViewById(R.id.tv_dislike);
        tvLike=itemView.findViewById(R.id.tv_like);
        tvShare=itemView.findViewById(R.id.tv_share);
        tvId=itemView.findViewById(R.id.tv_id);
        tvCaption=itemView.findViewById(R.id.tv_cap);
        imgClose=itemView.findViewById(R.id.img_close);
        isBleanLike=isBleanDisLike=isBleanComment=isBleanShare=isBleanClose=false;
    }

    void bind(final Gif gif) {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                Glide.with(itemView.getContext()).load(gif.getPreviewImageUrl()).centerCrop().into(previewImage);
                gifView.setVisibility(View.VISIBLE);
                gifView.start(gif.getPreviewMp4Url());
            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                Glide.with(itemView.getContext()).load(gif.getPreviewImageUrl()).fitCenter().into(previewImage);
                gifView.setVisibility(View.VISIBLE);
                gifView.start(gif.getPreviewMp4Url());
            }
        });

        thread1.run();
        thread2.run();

        gifView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                gifView.release();
                gifView.setVisibility(View.GONE);
            }
        });
        previewImage.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                gifView.setVisibility(View.VISIBLE);
                gifView.start(gif.getPreviewMp4Url());
            }
        });

        imgLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBleanLike==false)
                {
                    if(tvLike.getText().toString()==""){
                        intLike=1;
                    }else {
                        intLike=Integer.parseInt(tvLike.getText().toString());
                    }
                tvLike.setText(""+intLike);
                    isBleanLike=true;
                }
                else {
                    intLike--;
                    if(intLike==0)
                        tvLike.setText("");
                    else tvLike.setText(""+intLike);
                    isBleanLike=false;
                }
            }
        });
        imgDisLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBleanDisLike==false)
                {
                    if(tvDisLike.getText().toString()==""){
                        intDislike=1;
                    }else {
                        intDislike=Integer.parseInt(tvDisLike.getText().toString());
                    }
                    tvDisLike.setText(""+intDislike);
                    isBleanDisLike=true;
                }
                else {
                    intDislike--;
                    if(intDislike==0)
                        tvDisLike.setText("");
                    else tvDisLike.setText(""+intDislike);
                    isBleanDisLike=false;
                }
            }
        });
        imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment=new ShareDialogFragment();
                dialogFragment.show(activity.getFragmentManager(),"ShareDialogFragment");
            }
        });
        imgCommnent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBleanComment==false)
                {
                    if(tvComment.getText().toString()==""){
                        intComment=1;
                    }else {
                        intComment=Integer.parseInt(tvComment.getText().toString());
                    }
                    tvComment.setText(""+intComment);
                    isBleanComment=true;
                }
                else {
                    intComment--;
                    if(intComment==0)
                        tvComment.setText("");
                    else tvComment.setText(""+intComment);
                    isBleanComment=false;
                }
            }
        });
    }

    public void stopPlayback() {
        if (gifView.getVisibility() == View.VISIBLE) {
            gifView.release();
            gifView.setVisibility(View.GONE);
        }
    }
}
