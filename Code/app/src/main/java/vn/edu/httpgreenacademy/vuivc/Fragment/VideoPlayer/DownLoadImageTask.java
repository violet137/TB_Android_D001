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

    //ImageView imageView;
    GifImageView gifImageView;

//    public DownLoadImageTask(ImageView imageView){
//        this.imageView = imageView;
//    }

    public DownLoadImageTask(GifImageView gifImageView){
        this.gifImageView = gifImageView;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        String urlOfImage = urls[0];
        Bitmap logo = null;
        try{
            InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
            logo = BitmapFactory.decodeStream(is);
        }catch(Exception e){ // Catch the download exception
            e.printStackTrace();
        }
        return logo;
    }

    protected void onPostExecute(Bitmap result){
        //imageView.setImageBitmap(result);
        gifImageView.setImageBitmap(result);
    }
}
