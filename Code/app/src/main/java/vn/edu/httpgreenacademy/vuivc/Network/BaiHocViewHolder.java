package vn.edu.httpgreenacademy.vuivc.Network;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import vn.edu.httpgreenacademy.vuivc.R;

public class BaiHocViewHolder extends RecyclerView.ViewHolder {
    TextView txtTenBaiHoc;
    ImageView imgBaiHoc;

    public BaiHocViewHolder(@NonNull View itemView) {
        super(itemView);
        txtTenBaiHoc = itemView.findViewById(R.id.txtTenBaiHoc);
        imgBaiHoc = itemView.findViewById(R.id.imgBaiHoc);
    }

    public void SetData(BaiHoc model)
    {
        txtTenBaiHoc.setText(model.getName() + " (" + model.getNameTrans() + ")");
        imgBaiHoc.setImageURI(Uri.parse(model.getImageUrl()));
    }
}
