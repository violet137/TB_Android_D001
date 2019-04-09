package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.R;

public class HinhAnh_Adapter extends RecyclerView.Adapter<HinhAnh_Holder> {

    ArrayList<HinhAnh_Model> hinhAnhModelArrayList = new ArrayList<>();
    Activity activity;

    public HinhAnh_Adapter(ArrayList<HinhAnh_Model> hinhAnhModelArrayList, Activity activity) {
        this.hinhAnhModelArrayList = hinhAnhModelArrayList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public HinhAnh_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hinhanh,parent,false);
        return new HinhAnh_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HinhAnh_Holder hinhAnh_holder, int position) {
        final  HinhAnh_Model hinhAnh_model = hinhAnhModelArrayList.get(position);
        hinhAnh_holder.setdataHinhAnh(hinhAnh_model);
    }

    @Override
    public int getItemCount() {
        return hinhAnhModelArrayList.size();
    }
}
