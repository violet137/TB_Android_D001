package vn.edu.httpgreenacademy.vuivc;

import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    ArrayList<VideoModel> videoList = new ArrayList<VideoModel>();
    Thread thread;
    private int position = 0;
    RecyclerView recyclerView;

    public VideoAdapter(ArrayList<VideoModel> videoList, RecyclerView recyclerView1) {
        this.videoList = videoList;
        this.recyclerView = recyclerView1;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new VideoViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_item_video,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final VideoViewHolder videoViewHolder, final int i) {

        videoViewHolder.SetVideoData(videoList.get(i));
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
           try
           {

               if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                   videoViewHolder.videoViewPlayer.setBackground(videoViewHolder.videoViewPlayer.getBackground());
               }
               if(i == 0)
               {
                   recyclerView.scrollToPosition(i);
                   videoViewHolder.videoViewPlayer.start();
               }
               else
               {
                   videoViewHolder.videoViewPlayer.stopPlayback();
               }

               videoViewHolder.videoViewPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                   @Override
                   public void onPrepared(MediaPlayer mp) {
                       recyclerView.scrollToPosition(i);
                       mp.start();
                   }
               });

               videoViewHolder.videoViewPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                   @Override
                   public void onCompletion(MediaPlayer mp) {
                       recyclerView.scrollToPosition(i);
                       videoViewHolder.videoViewPlayer.start();
                   }
               });

               Thread.sleep(2000);
           }
           catch(Exception ex){
               ex.printStackTrace();
                }
            }
        });
        thread.start();
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

}
