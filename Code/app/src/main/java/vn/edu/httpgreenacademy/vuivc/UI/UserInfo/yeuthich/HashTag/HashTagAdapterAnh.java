package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.HashTag;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.R;

public class HashTagAdapterAnh extends RecyclerView.Adapter<HashTagViewHoder> {
    ArrayList<HashtagModel> hashtagModelArrayList = new ArrayList<>();
    Activity activity;

    public HashTagAdapterAnh(ArrayList<HashtagModel> hashtagModelArrayList, Activity activity) {
        this.hashtagModelArrayList = hashtagModelArrayList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public HashTagViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemhashtaganh,viewGroup,false);
        return new HashTagViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HashTagViewHoder hashTagViewHoder, int i) {
        HashtagModel hashtagModel = hashtagModelArrayList.get(i);
        hashTagViewHoder.setdataHashtag(hashtagModel);
    }

    @Override
    public int getItemCount() {
        return hashtagModelArrayList.size();
    }
}
