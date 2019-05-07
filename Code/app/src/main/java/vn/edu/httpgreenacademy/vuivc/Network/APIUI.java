package vn.edu.httpgreenacademy.vuivc.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIUI {
    public static  final  String SERVER_URI="http://13.229.117.90:8011";

    private static Retrofit retrofit=null;

    public static LessionService getLessionService(){
       if(retrofit==null){
           retrofit = new Retrofit.Builder().baseUrl(SERVER_URI).addConverterFactory(GsonConverterFactory.create()).build();
       }
       return retrofit.create(LessionService.class);
    }
}
