package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.HashTag;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.R;

public class FragmentHashtag extends Fragment {
    RecyclerView listanh, listvideo;
    ArrayList<HashtagModel> dataHashtagvideo = new ArrayList<>();
    ArrayList<HashtagModel> dataHashtagIMG = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hashtag, container, false);
        listanh = view.findViewById(R.id.listYeuthichHashtag);
        listvideo = view.findViewById(R.id.listYeuThichHashTag);

        dataHashtagvideo.clear();
        TypedArray video = getResources().obtainTypedArray(R.array.hinhanh);
        for (int i=0;i<video.length();i++)
        {
            HashtagModel hashtagModel = new HashtagModel(video.getResourceId(i,-1),video.getResourceId(i,-1));
            dataHashtagvideo.add(hashtagModel);
        }

        dataHashtagIMG.clear();
        TypedArray hinhanh = getResources().obtainTypedArray(R.array.hinhanh);
        for (int i=0;i<hinhanh.length();i++)
        {
            HashtagModel hashtagModel = new HashtagModel(hinhanh.getResourceId(i,-1),hinhanh.getResourceId(i,-1));
            dataHashtagIMG.add(hashtagModel);
        }

        listvideo.setLayoutManager(new GridLayoutManager(getContext(),3));
        HashTagAdapterVideo hashTagAdapterVideo = new HashTagAdapterVideo(dataHashtagvideo,getActivity());
        listvideo.setAdapter(hashTagAdapterVideo);
        listvideo.setHasFixedSize(true);


        listanh.setLayoutManager(new GridLayoutManager(getContext(),3));
        HashTagAdapterAnh hashTagAdapterAnh = new HashTagAdapterAnh(dataHashtagIMG,getActivity());
        listanh.setAdapter(hashTagAdapterAnh);



        return view;
    }
}
