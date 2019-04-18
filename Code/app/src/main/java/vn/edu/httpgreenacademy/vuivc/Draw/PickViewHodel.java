package vn.edu.httpgreenacademy.vuivc.Draw;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import vn.edu.httpgreenacademy.vuivc.R;

public class PickViewHodel extends RecyclerView.ViewHolder {
    ImageView duondanhinh;
    TextView tenhinhanh;
    View itemview;
    public PickViewHodel(@NonNull View itemView) {
        super(itemView);
        this.itemview = itemView;
        duondanhinh = itemView.findViewById(R.id.imgAnhSever);
        tenhinhanh = itemView.findViewById(R.id.txtTenAnh);
    }
    public void sethinhanh(PickModel pickModel)
    {
        duondanhinh.setImageResource(pickModel.duongdanhinh);
        tenhinhanh.setText(pickModel.tenhinh);
    }
}
