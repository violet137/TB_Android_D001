package vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import vn.edu.httpgreenacademy.vuivc.Adapter.ViewPagerAdapter;
import vn.edu.httpgreenacademy.vuivc.Fragment.DanhSach.FragmentDSVideo;
import vn.edu.httpgreenacademy.vuivc.Fragment.DanhSach.FragmentDanhSachFollowers;
import vn.edu.httpgreenacademy.vuivc.Fragment.DanhSach.FragmentDanhSachFollowing;
import vn.edu.httpgreenacademy.vuivc.Fragment.AboutApp.FragmentAboutApp;
import vn.edu.httpgreenacademy.vuivc.Interface.NhanDulieuTuUserMain;
import vn.edu.httpgreenacademy.vuivc.Interface.TruyenDuLieu;
import vn.edu.httpgreenacademy.vuivc.Interface.TruyenThongTinUser;
import vn.edu.httpgreenacademy.vuivc.ModelUser.ProfileUser;
import vn.edu.httpgreenacademy.vuivc.R;

public class FragmentUserMain extends Fragment implements View.OnClickListener, TruyenDuLieu, TruyenThongTinUser {
    ViewPager viewPager;
    TabLayout tabLayout;
    LinearLayout line1, line2, line3;
    ImageButton imgbtn_setting;
    ImageView imgAnhdaidien;
    FragmentEditProfile fragmentEditProfile = new FragmentEditProfile();
    FragmentAboutApp fragmentAboutApp;
    ProfileUser profileUser;
    FragmentDanhSachFollowers fragmentDanhSachFollowers = new FragmentDanhSachFollowers();
    FragmentDanhSachFollowing fragmentDanhSachFollowing = new FragmentDanhSachFollowing();
    public TextView txt_SoLuongVideo, txt_SoluongFollower, txt_SoluongFollowing, txtTenUser, txtID;
    FragmentDSVideo fragmentdsVideos = new FragmentDSVideo();
    int SoluongFollower,SoLuongFollowing,SoLuongVideo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.af);
        profileUser = new ProfileUser(bitmap, 222222222, 25, 5, 5, true, "Nghĩa", "24/10/1997");
        SoluongFollower =profileUser.getNumFollower();
        SoLuongFollowing = profileUser.getNumFollowing();
        SoLuongVideo =profileUser.getNumVideo();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profileuser_main, container, false);
        viewPager = view.findViewById(R.id.vp);
        tabLayout = view.findViewById(R.id.tabLayout);
        imgbtn_setting = view.findViewById(R.id.imgbtn_setting);
        txt_SoLuongVideo = view.findViewById(R.id.txt_SoLuongVideo);
        txt_SoluongFollower = view.findViewById(R.id.txt_SoLuongFollowers);
        txt_SoluongFollowing = view.findViewById(R.id.txt_SoLuongFollowing);
        imgAnhdaidien = view.findViewById(R.id.imgAnhUser);
        txtTenUser = view.findViewById(R.id.txtTenUser);
        txtID = view.findViewById(R.id.txtID);
        line1 = view.findViewById(R.id.line1);
        line2 = view.findViewById(R.id.line2);
        line3 = view.findViewById(R.id.line3);

        ViewPagerAdapter viewPager_adapter = new ViewPagerAdapter(getChildFragmentManager());//Vi no duoc chua trong mot Fragment
        viewPager.setAdapter(viewPager_adapter);
        tabLayout.setupWithViewPager(viewPager);

        imgbtn_setting.setOnClickListener(this);
        line1.setOnClickListener(this);
        line2.setOnClickListener(this);
        line3.setOnClickListener(this);

        fragmentEditProfile.FragmentEditProfile(this);//lắng nghe du lieu tu Edit profile
        fragmentDanhSachFollowers.TruyensoluongFollowers(this);
        fragmentDanhSachFollowing.TruyensoluongFollowing(this);

        txtTenUser.setText(profileUser.getNameUser());
        txtID.setText(profileUser.getId() + "");
        txt_SoluongFollower.setText(SoluongFollower+"");
        txt_SoluongFollowing.setText(SoLuongFollowing+"");
        txt_SoLuongVideo.setText(SoLuongVideo+"");
        imgAnhdaidien.setImageBitmap(profileUser.getPhoto());
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgbtn_setting:
                PopupMenu popupMenu = new PopupMenu(getContext(), imgbtn_setting);
                popupMenu.getMenuInflater().inflate(R.menu.menu_setting, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.iteditprofile:
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("information",profileUser);
                                fragmentEditProfile.setArguments(bundle);
                                ChuyenFragment(fragmentEditProfile);
                                break;
                            case R.id.about:
                                fragmentAboutApp = new FragmentAboutApp();
                                ChuyenFragment(fragmentAboutApp);
                                break;
                            case R.id.logout:
                                AlertDialog.Builder logout_dialog = new AlertDialog.Builder(getActivity());
                                logout_dialog.setMessage("Do you want to log out ?");
                                logout_dialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });
                                logout_dialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });
                                AlertDialog alertDialog = logout_dialog.create();
                                alertDialog.show();
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
                Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_button_setting);
                imgbtn_setting.startAnimation(animation);
                break;
            case R.id.line1:
                ChuyenFragment(fragmentdsVideos);
                break;
            case R.id.line2:
                ChuyenFragment(fragmentDanhSachFollowers);
                break;
            case R.id.line3:
                ChuyenFragment(fragmentDanhSachFollowing);
                break;
        }

    }

    private void ChuyenFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(android.R.id.content, fragment).addToBackStack("").commit();
    }

    @Override
    public void GetSoluongVideo(int soluong) {
        SoLuongVideo = soluong;
    }

    @Override
    public void GetDuLieuEditProfile(String tenuser, String ngaysinh, boolean gioitinh,Bitmap bitmap) {
        if (tenuser != null) {
            profileUser.setNameUser(tenuser);
            profileUser.setPhoto(bitmap);
        }

    }

    @Override
    public void GetSoluongFollower(int soluong) {
        SoluongFollower =soluong;
    }

    @Override
    public void GetSoluongFollowing(int soluong) {
        SoLuongFollowing = soluong;
    }
}