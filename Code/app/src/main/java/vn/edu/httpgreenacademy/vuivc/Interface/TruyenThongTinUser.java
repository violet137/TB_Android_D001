package vn.edu.httpgreenacademy.vuivc.Interface;

import android.graphics.Bitmap;

import com.squareup.picasso.Picasso;

public interface TruyenThongTinUser {
    public void GetDuLieuEditProfile(String tenuser, String ngaysinh, boolean gioitinh, Bitmap image);
}
