package vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser;


import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.IOException;

import vn.edu.httpgreenacademy.vuivc.Dialog.DialogChangeImage;

import vn.edu.httpgreenacademy.vuivc.Interface.NhanDulieuTuUserMain;
import vn.edu.httpgreenacademy.vuivc.Interface.TruyenThongTinUser;
import vn.edu.httpgreenacademy.vuivc.ModelUser.ProfileUser;
import vn.edu.httpgreenacademy.vuivc.R;

import static android.app.Activity.RESULT_OK;

public class FragmentEditProfile extends Fragment implements View.OnClickListener {
    ImageView img_Quaylai,imgDoiAnh,imgAnhDaiDien;
    EditText edt_ten,edt_ngaysinh;
    RadioButton rbNam,rbNu;
    TextView txtLuu,txt_ID;
    String gioitinh;
    Bitmap bitmap;
    String tenUser,ngaySinh;
    boolean sex=true;

    TruyenThongTinUser truyenThongTinUser;
    public void FragmentEditProfile(TruyenThongTinUser truyenDuLieu) { //Bắn dữ liệu cho UserMain
        this.truyenThongTinUser = truyenDuLieu;
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
        imgDoiAnh = view.findViewById(R.id.circle_crop);
        imgAnhDaiDien = view.findViewById(R.id.img_DoiAnh);
        txt_ID = view.findViewById(R.id.txt_id);

        img_Quaylai.setOnClickListener(this);
        rbNu.setOnClickListener(this);
        rbNam.setOnClickListener(this);
        txtLuu.setOnClickListener(this);
        //Nhan du lieu tu User Main
        Bundle bundle = getArguments();
        ProfileUser profileUser = (ProfileUser) bundle.getSerializable("information");
        txt_ID.setText(profileUser.getId()+"");
        edt_ten.setText(profileUser.getNameUser());
        edt_ngaysinh.setText(profileUser.getNgaySinh());

        if(profileUser.isSex())
        {
            CheckBuild(rbNam);
            rbNam.setChecked(true);
            CheckBuild(rbNu);
        }
        else {
            CheckBuild(rbNu);
            rbNu.setChecked(true);
            CheckBuild(rbNam);
        }

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
                sex = true;
                CheckBuild(rbNam);
                break;
            case R.id.rb_nu:
                gioitinh = rbNu.getText().toString();
                CheckBuild(rbNu);
                sex = false;
                break;
            case R.id.txt_Luu:
                truyenThongTinUser.GetDuLieuEditProfile(edt_ten.getText().toString(),edt_ngaysinh.getText().toString(),sex,bitmap);
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 100)
        {
            if(resultCode == RESULT_OK)
            {
               bitmap = (Bitmap) data.getExtras().get("data");
                imgAnhDaiDien.setImageBitmap(bitmap);
            }
        }
        else if(requestCode ==200)
        {
            if(resultCode==RESULT_OK)
                try {
                    Uri imageUri = data.getData();
                    bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);
                    imgAnhDaiDien.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    private void CheckBuild(RadioButton radioButton) {
        if(Build.VERSION.SDK_INT>=21)
        {

            ColorStateList colorStateList = new ColorStateList(
                    new int[][]{

                            new int[]{-android.R.attr.state_enabled}, //disabled
                            new int[]{android.R.attr.state_enabled} //enabled
                    },
                    new int[] {

                            Color.WHITE //disabled
                            ,Color.YELLOW //enabled

                    }
            );


            radioButton.setButtonTintList(colorStateList);//set the color tint list
            radioButton.invalidate(); //could not be necessary
        }
    }

}

