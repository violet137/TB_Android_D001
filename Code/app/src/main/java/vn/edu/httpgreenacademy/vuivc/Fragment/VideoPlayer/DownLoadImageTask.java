package vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

import pl.droidsonroids.gif.GifImageView;
import vn.edu.httpgreenacademy.vuivc.GifView;

public class DownLoadImageTask extends AsyncTask<String,Void, Bitmap> {

    GifImageView gifImageView;
    public DownLoadImageTask(GifImageView gifImageView){
        this.gifImageView = gifImageView;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        String urlOfImage = urls[0];
        Bitmap logo = null;
        try{
            InputStream is = new URL(urlOfImage).openStream();
            logo = BitmapFactory.decodeStream(is);
        }catch(Exception e){ // Catch the download exception
            e.printStackTrace();
        }
        return logo;
    }

    protected void onPostExecute(Bitmap result){
        gifImageView.setImageBitmap(result);
    }
}
