package vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
    Bitmap image;
    String tenUser,ngaySinh;
    boolean sex=true;
    ProfileUser profileUser;

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
        imgAnhDaiDien.setOnClickListener(this);
        //Nhan du lieu tu User Main
        Bundle bundle = getArguments();
        profileUser = (ProfileUser) bundle.getSerializable("information");
        txt_ID.setText(profileUser.getId()+"");
        edt_ten.setText(profileUser.getNameUser());
        edt_ngaysinh.setText(profileUser.getNgaySinh());

        if(profileUser.isSex().equalsIgnoreCase("male"))
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
                profileUser.setSex(rbNam.getText().toString());
                break;
            case R.id.rb_nu:
                gioitinh = rbNu.getText().toString();
                CheckBuild(rbNu);
                sex = false;
                profileUser.setSex(rbNu.getText().toString());
                break;
            case R.id.txt_Luu:
                profileUser.setNameUser(edt_ten.getText().toString());
                profileUser.setNgaySinh(edt_ngaysinh.getText().toString());
                truyenThongTinUser.GetDuLieuEditProfile(profileUser);
                getFragmentManager().popBackStack();
                break;
            case R.id.img_DoiAnh:
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
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 300)
        {
            if(resultCode == Activity.RESULT_OK)
            {
               image = (Bitmap) data.getExtras().get("data");
                profileUser.setPhoto(image);
               imgAnhDaiDien.setImageBitmap(image);
            }
        }
        else if(requestCode ==200)
        {
            if(resultCode==RESULT_OK) {
                Uri imageUri = data.getData();
                try {
                    image = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                imgAnhDaiDien.setImageBitmap(image);
                profileUser.setPhoto(image);
             /*   SharedPreferences userAvatarSharedPreferences = getActivity().getSharedPreferences("session_user_avatar", Context.MODE_PRIVATE);
                SharedPreferences.Editor userAvatarEditor = userAvatarSharedPreferences.edit();
                userAvatarEditor.putString("remember_user_avatar",imageUri.getPath());
                Log.d("hinh dai dien",imageUri.getPath());
                userAvatarEditor.commit();*/
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

