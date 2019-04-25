package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.HashTag;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.R;

public class FragmentHashtag extends Fragment {
    RecyclerView listYeuThichHashtag,listYeuThichHashTag;
    ArrayList<HashtagModel> dataHashtag = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hashtag, container, false);
        listYeuThichHashtag = view.findViewById(R.id.listYeuthichHashtag);
        listYeuThichHashTag = view.findViewById(R.id.listYeuThichHashTag);

        dataHashtag.clear();
        TypedArray hinhanh = getResources().obtainTypedArray(R.array.hinhanh);
        for (int i=0;i<hinhanh.length();i++)
        {
            HashtagModel hashtagModel = new HashtagModel(hinhanh.getResourceId(i,-1),hinhanh.getResourceId(i,-1));
            dataHashtag.add(hashtagModel);
        }

        listYeuThichHashTag.setLayoutManager(new GridLayoutManager(getContext(),3));
        HashTagVideoAdapter hashTagVideoAdapter = new HashTagVideoAdapter(dataHashtag,getActivity());
        listYeuThichHashTag.setAdapter(hashTagVideoAdapter);
        listYeuThichHashTag.setHasFixedSize(true);
        listYeuThichHashtag.setLayoutManager(new GridLayoutManager(getContext(),3));
        HashTagAdapterAnh hashTagAdapterAnh = new HashTagAdapterAnh(dataHashtag,getActivity());
        listYeuThichHashtag.setAdapter(hashTagAdapterAnh);



        return view;
    }
}
