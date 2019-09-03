package vn.edu.httpgreenacademy.vuivc.Api;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import vn.edu.httpgreenacademy.vuivc.Model.VideoModel;
import vn.edu.httpgreenacademy.vuivc.ModelUser.ProfileUser;

public interface VideoService {

    @GET("api/v1/VuiVCVideo")
    Call<List<VideoModel>> GetVideoList();

    @GET("api/v1/VuiVCUser/{id}")
    Call<ProfileUser> GetProfileUser(@Path("id") int id);

    @GET("api/v1/VuiVCImage")
    Call<List<VideoModel>> GetVideoTempList();
}
