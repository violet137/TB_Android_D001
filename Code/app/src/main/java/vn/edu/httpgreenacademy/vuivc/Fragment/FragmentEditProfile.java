package vn.edu.httpgreenacademy.vuivc.Fragment;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TextView;

import vn.edu.httpgreenacademy.vuivc.Dialog.DialogChangeImage;
import vn.edu.httpgreenacademy.vuivc.Interface.TakeImage;
import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.Interface.TruyenDuLieu;

public class FragmentEditProfile extends Fragment implements View.OnClickListener, TakeImage {
    ImageView img_Quaylai,imgDoiAnh,imgAnhDaiDien;
    EditText edt_ten,edt_ngaysinh;
    RadioButton rbNam,rbNu;
    TextView txtLuu;
    String gioitinh;
    TruyenDuLieu truyenDuLieu;
    Bitmap bitmap1;
    DialogChangeImage dialogChangeImage= new DialogChangeImage();
    public void FragmentEditProfile(TruyenDuLieu truyenDuLieu) {
        this.truyenDuLieu = truyenDuLieu;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bitmap1 =null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_edit_user,container,false);
        img_Quaylai = view.findViewById(R.id.img_QuayLai);
        edt_ngaysinh = view.findViewById(R.id.edt_Ngaysinh);
        edt_ten = view.findViewById(R.id.edt_HovaTen);
        txtLuu = view.findViewById(R.id.txt_Luu);
        rbNam = view.findViewById(R.id.rb_Nam);
        rbNu = view.findViewById(R.id.rb_nu);
        img_Quaylai.setOnClickListener(this);
        rbNu.setOnClickListener(this);
        rbNam.setOnClickListener(this);
        txtLuu.setOnClickListener(this);
        imgDoiAnh = view.findViewById(R.id.circle_crop);
        imgAnhDaiDien = view.findViewById(R.id.img_DoiAnh);
        imgDoiAnh.setOnClickListener(this);
        dialogChangeImage.TakeImage(this);
        imgAnhDaiDien.setImageBitmap(bitmap1);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.img_QuayLai:
                getFragmentManager().popBackStack();
                break;
            case R.id.rb_Nam:
                gioitinh = rbNam.getText().toString();
                break;
            case R.id.rb_nu:
                gioitinh = rbNu.getText().toString();

                break;
            case R.id.txt_Luu:
                truyenDuLieu.GetDuLieuEditProfile(edt_ten.getText().toString(),edt_ngaysinh.getText().toString(),gioitinh);
                getFragmentManager().popBackStack();
                break;
            case R.id.circle_crop:
                ChangeAnh();
                break;
        }
    }

    private void ChangeAnh() {
        DialogChangeImage dialog = new DialogChangeImage();
        dialog.show(getFragmentManager(),null);
        }

    @Override
    public void imagefromCamera(Bitmap bitmap) {
        bitmap1 = bitmap;
    }

}

