package vn.edu.httpgreenacademy.vuivc.Fragment;

import android.content.DialogInterface;
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
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import vn.edu.httpgreenacademy.vuivc.Adapter.ViewPagerAdapter;
import vn.edu.httpgreenacademy.vuivc.Interface.TruyenDuLieu;
import vn.edu.httpgreenacademy.vuivc.ModelUser.ProfileUser;
import vn.edu.httpgreenacademy.vuivc.R;

public class FragmentUserMain extends Fragment implements View.OnClickListener, TruyenDuLieu {
    ViewPager viewPager;
    TabLayout tabLayout;
    LinearLayout line1, line2, line3;
    ImageButton imgbtn_setting;
    FragmentEditProfile fragmentEditProfile = new FragmentEditProfile();
    FragmentAboutApp fragmentAboutApp;
    ProfileUser profileUser;
    FragmentDanhSachFollowers fragmentDanhSachFollowers = new FragmentDanhSachFollowers();
    FragmentDanhSachFollowing fragmentDanhSachFollowing = new FragmentDanhSachFollowing();
    TextView txt_SoLuongVideo, txt_SoluongFollower, txt_SoluongFollowing, txtTenUser, txtID;
    FragmentDSVideo fragmentdsVideos = new FragmentDSVideo();

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
        txtTenUser = view.findViewById(R.id.txtTenUser);
        txtID = view.findViewById(R.id.txtID);
        line1 = view.findViewById(R.id.line1);
        line2 = view.findViewById(R.id.line2);
        line3 = view.findViewById(R.id.line3);

        ViewPagerAdapter viewPager_adapter = new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(viewPager_adapter);
        tabLayout.setupWithViewPager(viewPager);

        imgbtn_setting.setOnClickListener(this);
        line1.setOnClickListener(this);
        line2.setOnClickListener(this);
        line3.setOnClickListener(this);

        fragmentEditProfile.FragmentEditProfile(this);//lắng nghe du lieu tu Edit profile
        fragmentDanhSachFollowers.Truyensoluong(this);
        profileUser = new ProfileUser(R.drawable.af, 222222222, 25, 5, 5, true, "Nghĩa", "24/10/1997");
        txtTenUser.setText(profileUser.getNameUser());
        txtID.setText(profileUser.getId() + "");


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
                        switch (menuItem.toString()) {
                            case "Edit your profile":
                                ChuyenFragment(fragmentEditProfile);
                                break;
                            case "About":
                                fragmentAboutApp = new FragmentAboutApp();
                                ChuyenFragment(fragmentAboutApp);
                                break;
                            case "Log out":
                                AlertDialog.Builder logout_dialog = new AlertDialog.Builder(getActivity());
                                logout_dialog.setMessage("Do you want to log out ?");
                                logout_dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });
                                logout_dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
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
        txt_SoluongFollower.setText(soluong + "");
    }

    @Override
    public void GetDuLieuEditProfile(String tenuser, String ngaysinh, String gioitinh) {
        if (tenuser != null) {
            txtTenUser.setText(tenuser);
        }

    }
}
