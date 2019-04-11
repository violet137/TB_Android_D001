package vn.edu.httpgreenacademy.vuivc.Network;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import vn.edu.httpgreenacademy.vuivc.R;

public class BaiHocAdapter extends RecyclerView.Adapter<BaiHocViewHolder> {
    List<BaiHoc> listBaiHoc;

    public BaiHocAdapter(List<BaiHoc> listBaiHoc) {
        this.listBaiHoc = listBaiHoc;
    }

    @NonNull
    @Override
    public BaiHocViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BaiHocViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_baihoc, viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaiHocViewHolder baiHocViewHolder, int i) {
        baiHocViewHolder.SetData(listBaiHoc.get(i));
    }

    @Override
    public int getItemCount() {
        return listBaiHoc.size();
    }

}
