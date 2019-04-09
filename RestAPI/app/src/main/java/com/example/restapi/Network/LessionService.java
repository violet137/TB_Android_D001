package com.example.restapi.Network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LessionService {
    @GET("/api/Lession/GetLessionAll")
    Call<LessModel> getLession();
}
