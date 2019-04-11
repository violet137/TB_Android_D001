package vn.edu.httpgreenacademy.vuivc.Network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtils {

    public static final String SERVER_URL = "http://13.229.117.90:8011";

    private static Retrofit retrofit = null;

    public static LessionService getLessionService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().
                    baseUrl(SERVER_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(LessionService.class);
    }
}
