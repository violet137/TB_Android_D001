package vn.edu.httpgreenacademy.vuivc.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.edu.httpgreenacademy.vuivc.Model.VideoModel;

import static com.facebook.FacebookSdk.getApplicationContext;

public class ApiUtils {

    public static final String SERVER_URL = "http://5d0b095389166d00146e3337.mockapi.io/";
    private static Retrofit retrofit = null;

    // Khoi tao Retrofit
    public static VideoService GetVideoService()
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(SERVER_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(VideoService.class);
    }



}
