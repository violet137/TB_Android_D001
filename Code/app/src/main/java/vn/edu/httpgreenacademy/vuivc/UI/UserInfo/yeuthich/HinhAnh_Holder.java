package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import vn.edu.httpgreenacademy.vuivc.R;

public class HinhAnh_Holder extends RecyclerView.ViewHolder {
    ImageView duongdanhinh;
    View itemView;
    public HinhAnh_Holder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        duongdanhinh = itemView.findViewById(R.id.Item_HinhAnh);
    }
    public void setdataHinhAnh(HinhAnh_Model hinhAnh_model)
    {
        duongdanhinh.setImageResource(hinhAnh_model.duongdanhinh);
    }
}
