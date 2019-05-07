package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.HinhAnh;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import vn.edu.httpgreenacademy.vuivc.R;

public class HinhAnhViewHolder extends RecyclerView.ViewHolder {
    ImageView duongdanhinh;
    View itemView;
    public HinhAnhViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        duongdanhinh = itemView.findViewById(R.id.Item_HinhAnh);
    }
    public void setdataHinhAnh(HinhAnhModel hinhAnh_model)
    {
        duongdanhinh.setImageResource(hinhAnh_model.duongdanhinh);
    }
}
