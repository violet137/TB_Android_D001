package vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import vn.edu.httpgreenacademy.vuivc.Api.ApiUtils;
import vn.edu.httpgreenacademy.vuivc.Enum.VideoTypeEnum;
import vn.edu.httpgreenacademy.vuivc.MainActivity;
import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.ViewPager.VerticalViewPager;
import vn.edu.httpgreenacademy.vuivc.Model.VideoModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.httpgreenacademy.vuivc.http_httpsRequest.AsyncTaskCompleteListener;
import vn.edu.httpgreenacademy.vuivc.http_httpsRequest.VollyRequester;

public class VerticalVideoFragment extends Fragment implements AsyncTaskCompleteListener {

    VerticalViewPager verticalviewpager;
    ArrayList<VideoModel> listVideo = new ArrayList<VideoModel>();
    VerticalPagerAdapter verticalPagerAdapter;
    int mNum;
    private static VerticalVideoFragment verticalVideoFragment;

    public VerticalVideoFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewVerticalViewPager = inflater.inflate(R.layout.fragment_verticalvp, container, false);

        verticalviewpager = viewVerticalViewPager.findViewById(R.id.verticalviewpager);
        Log.d("number", "" + mNum);

        getDataVideo();

//        ApiUtils.GetVideoService().GetVideoList().enqueue(new Callback<List<VideoModel>>() {
//            @Override
//            public void onResponse(Call<List<VideoModel>> call, Response<List<VideoModel>> response) {
//                if(response.isSuccessful()){
//                    List<VideoModel> list = response.body();
//                    listVideo = new ArrayList(list);
//                    verticalPagerAdapter = new VerticalPagerAdapter(getFragmentManager(),listVideo);
//                    verticalviewpager.setAdapter(verticalPagerAdapter);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<VideoModel>> call, Throwable t) {
//                Log.d("Error","" + t.getMessage());
//            }
//        });
            return viewVerticalViewPager;
    }

    private void getDataVideo()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("url","https://gitlab.com/tungxuan15419991/vuivc/raw/master/VideoVuiVC");
        //method_type: 0 -> Get 1 -> Post
        new VollyRequester(MainActivity.activity, 0, map, 111,
                this);
    }


    ArrayList<VideoModel> arrayList;
    @Override
    public void onTaskCompleted(String response, int serviceCode) {
        switch (serviceCode)
        {
            case 111:
            {
                arrayList = new ArrayList<>();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean("success")){
                        Log.d("asdasd",response);
                        JSONArray data = jsonObject.getJSONArray("data");

                        for (int i = 0; i < data.length(); i++)
                        {
                            JSONObject video = (JSONObject) data.get(i);
                            arrayList.add(new VideoModel(video.getInt("id"),video.getString("VideoName"),video.getString("VideoUrl"),
                                    VideoTypeEnum.valueOf(video.getString("videoType")),video.getInt("VideoUploaderId"),video.getInt("NumberOfLike"),video.getInt("NumberOfShare"),video.getInt("NumberOfComment")));
                        }
                        verticalPagerAdapter = new VerticalPagerAdapter(getFragmentManager(),arrayList);
                        verticalviewpager.setAdapter(verticalPagerAdapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }
}