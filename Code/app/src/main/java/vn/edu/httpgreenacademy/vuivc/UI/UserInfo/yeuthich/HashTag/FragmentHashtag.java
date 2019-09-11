package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.HashTag;

import android.content.res.TypedArray;
import android.os.Bundle;

<<<<<<< HEAD
=======

>>>>>>> df31fef4cf55d8603a8b118f4fd747e8302e3f4f
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
    RecyclerView listYeuthichHashtag,listYeuThichHashTag;
    ArrayList<HashtagModel> dataHashtagvideo = new ArrayList<>();
    ArrayList<HashtagModel> dataHashtagIMG = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hashtag, container, false);
        listYeuthichHashtag = view.findViewById(R.id.listYeuthichHashtag);
        listYeuThichHashTag = view.findViewById(R.id.listYeuThichHashTag);

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

        listYeuThichHashTag.setLayoutManager(new GridLayoutManager(getContext(),3));
        HashTagAdapterVideo hashTagAdapterVideo = new HashTagAdapterVideo(dataHashtagvideo,getActivity());
        listYeuThichHashTag.setAdapter(hashTagAdapterVideo);
        listYeuThichHashTag.setHasFixedSize(true);


        listYeuthichHashtag.setLayoutManager(new GridLayoutManager(getContext(),3));
        HashTagAdapterAnh hashTagAdapterAnh = new HashTagAdapterAnh(dataHashtagIMG,getActivity());
        listYeuthichHashtag.setAdapter(hashTagAdapterAnh);



        return view;
    }
}
