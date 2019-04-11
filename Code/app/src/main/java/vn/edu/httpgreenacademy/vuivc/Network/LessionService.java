package vn.edu.httpgreenacademy.vuivc.Network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LessionService {

    @GET("/api/Lession/GetLessionAll")
    Call<LessionModel> getLession();


}
