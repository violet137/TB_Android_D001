package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.HinhAnh;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.R;

public class HinhAnhAdapter extends RecyclerView.Adapter<HinhAnhViewHolder> {

    ArrayList<HinhAnhModel> hinhAnhModelArrayList = new ArrayList<>();
    Activity activity;

    public HinhAnhAdapter(ArrayList<HinhAnhModel> hinhAnhModelArrayList, Activity activity) {
        this.hinhAnhModelArrayList = hinhAnhModelArrayList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public HinhAnhViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hinhanh,parent,false);
        return new HinhAnhViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HinhAnhViewHolder hinhAnh_holder, int position) {
        final HinhAnhModel hinhAnh_model = hinhAnhModelArrayList.get(position);
        hinhAnh_holder.setdataHinhAnh(hinhAnh_model);
    }

    @Override
    public int getItemCount() {
        return hinhAnhModelArrayList.size();
    }

}
