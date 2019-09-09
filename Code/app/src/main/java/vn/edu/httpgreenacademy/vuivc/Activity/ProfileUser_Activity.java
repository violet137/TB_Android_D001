package vn.edu.httpgreenacademy.vuivc.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
<<<<<<< HEAD:Code/app/src/main/java/vn/edu/httpgreenacademy/vuivc/Activity/ProfileUser_Activity.java
=======
import android.os.Bundle;
>>>>>>> beefe2283a34784b2a1f08cdbc25c03d40cfed40:Code/app/src/main/java/vn/edu/httpgreenacademy/vuivc/Fragment/ProfileUser/FragmentUserMain.java
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
<<<<<<< HEAD:Code/app/src/main/java/vn/edu/httpgreenacademy/vuivc/Activity/ProfileUser_Activity.java
import android.support.v4.app.FragmentTransaction;
=======
>>>>>>> beefe2283a34784b2a1f08cdbc25c03d40cfed40:Code/app/src/main/java/vn/edu/httpgreenacademy/vuivc/Fragment/ProfileUser/FragmentUserMain.java
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
<<<<<<< HEAD:Code/app/src/main/java/vn/edu/httpgreenacademy/vuivc/Activity/ProfileUser_Activity.java
=======
import android.view.KeyEvent;
import android.view.LayoutInflater;
>>>>>>> beefe2283a34784b2a1f08cdbc25c03d40cfed40:Code/app/src/main/java/vn/edu/httpgreenacademy/vuivc/Fragment/ProfileUser/FragmentUserMain.java
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.facebook.login.LoginManager;

import java.io.File;
import java.net.URL;

import vn.edu.httpgreenacademy.vuivc.Adapter.ViewPagerAdapter;
import vn.edu.httpgreenacademy.vuivc.Enum.UserTypeEnum;
import vn.edu.httpgreenacademy.vuivc.Fragment.DanhSach.FragmentDSVideo;
import vn.edu.httpgreenacademy.vuivc.Fragment.DanhSach.FragmentDanhSachFollowers;
import vn.edu.httpgreenacademy.vuivc.Fragment.DanhSach.FragmentDanhSachFollowing;
<<<<<<< HEAD:Code/app/src/main/java/vn/edu/httpgreenacademy/vuivc/Activity/ProfileUser_Activity.java
import vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser.FragmentEditProfile;
=======
import vn.edu.httpgreenacademy.vuivc.Fragment.AboutApp.FragmentAboutApp;
>>>>>>> beefe2283a34784b2a1f08cdbc25c03d40cfed40:Code/app/src/main/java/vn/edu/httpgreenacademy/vuivc/Fragment/ProfileUser/FragmentUserMain.java
import vn.edu.httpgreenacademy.vuivc.Interface.TruyenDuLieu;
import vn.edu.httpgreenacademy.vuivc.Interface.TruyenThongTinUser;
import vn.edu.httpgreenacademy.vuivc.MainActivity;
import vn.edu.httpgreenacademy.vuivc.ModelUser.ProfileUser;
import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.UI.Login.FragmentLogin;
import vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.FragmentYeuThich;

public class ProfileUser_Activity extends AppCompatActivity implements View.OnClickListener, TruyenDuLieu, TruyenThongTinUser {

    LinearLayout line1, line2, line3;
    ImageButton imgbtn_setting;
    ImageView imgAnhdaidien;
    FragmentEditProfile fragmentEditProfile = new FragmentEditProfile();
    ProfileUser profileUser;
    FragmentDanhSachFollowers fragmentDanhSachFollowers = new FragmentDanhSachFollowers();
    FragmentDanhSachFollowing fragmentDanhSachFollowing = new FragmentDanhSachFollowing();
    public TextView txt_SoLuongVideo, txt_SoluongFollower, txt_SoluongFollowing, txtTenUser, txtID,txtSex, txtDate;
    FragmentDSVideo fragmentdsVideos = new FragmentDSVideo();
    int SoluongFollower,SoLuongFollowing,SoLuongVideo;
    int ID_LOGIN;
    URL urlimage;
    Bitmap profilePic;
    private int mPage;
    private String mTitle;

    @Override
<<<<<<< HEAD:Code/app/src/main/java/vn/edu/httpgreenacademy/vuivc/Activity/ProfileUser_Activity.java
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profileuser_main);
=======
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profileuser_main, container, false);

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event )
            {
                Log.d("Keyevent", ""+keyCode);
                if( keyCode == KeyEvent.KEYCODE_BACK )
                {
                    getActivity().finish();
                    getActivity().startActivity(new Intent(getActivity(),MainActivity.class));
                    return true;
                }
                return false;
            }
        } );

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
>>>>>>> beefe2283a34784b2a1f08cdbc25c03d40cfed40:Code/app/src/main/java/vn/edu/httpgreenacademy/vuivc/Fragment/ProfileUser/FragmentUserMain.java

        imgbtn_setting = findViewById(R.id.imgbtn_setting);
        txt_SoLuongVideo = findViewById(R.id.txt_SoLuongVideo);
        txt_SoluongFollower = findViewById(R.id.txt_SoLuongFollowers);
        txt_SoluongFollowing = findViewById(R.id.txt_SoLuongFollowing);
        txtSex = findViewById(R.id.txtSex);
        txtDate = findViewById(R.id.txtDate);
        imgAnhdaidien = findViewById(R.id.imgAnhUser);
        txtTenUser = findViewById(R.id.txtTenUser);
        txtID = findViewById(R.id.txtID);
        line1 = findViewById(R.id.line1);
        line2 = findViewById(R.id.line2);
        line3 = findViewById(R.id.line3);
        profileUser = new ProfileUser();
        SoluongFollower =profileUser.getNumFollower();
        SoLuongFollowing = profileUser.getNumFollowing();
        SoLuongVideo =profileUser.getNumVideo();

        imgbtn_setting.setOnClickListener(this);
        line1.setOnClickListener(this);
        line2.setOnClickListener(this);
        line3.setOnClickListener(this);

        fragmentEditProfile.FragmentEditProfile(this);//lắng nghe du lieu tu Edit profile
        fragmentDanhSachFollowers.TruyensoluongFollowers(this);
        fragmentDanhSachFollowing.TruyensoluongFollowing(this);
        txt_SoluongFollower.setText(SoluongFollower+"");
        txt_SoluongFollowing.setText(SoLuongFollowing+"");
        txt_SoLuongVideo.setText(SoLuongVideo+"");


        // Get user login
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(getString(R.string.fb_sharePre_Name), Context.MODE_PRIVATE);
        if(sharedPref != null)
        {
            String facebookUserId = sharedPref.getString("fb_sharePre_login_id", "");
            if(!facebookUserId.isEmpty())
            {
                profileUser.setNameUser(sharedPref.getString("fb_sharePre_login_name", ""));
                profileUser.setId(sharedPref.getString("fb_sharePre_login_email", ""));
                profileUser.setNgaySinh(sharedPref.getString("fb_sharePre_login_birthday", ""));
                profileUser.setSex(sharedPref.getString("fb_sharePre_login_gender", ""));
                profileUser.setUserType(UserTypeEnum.Facebook);
                txtTenUser.setText(profileUser.getNameUser());
                txtID.setText(profileUser.getId());
                ID_LOGIN=1;
            }
        }
        else
        {
            txtTenUser.setText(profileUser.getNameUser());
            txtID.setText(profileUser.getId() + "");
            txtSex.setText("---");
            txtDate.setText("--/--/----");
        }

       /* SharedPreferences userAvatarSharedPref = getApplicationContext().getSharedPreferences("session_user_avatar",Context.MODE_PRIVATE);
        if(userAvatarSharedPref != null)
        {
            String image = userAvatarSharedPref.getString("remember_user_avatar","");

            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),image);
            String img_nhan = file.getAbsolutePath();
            imgAnhdaidien.setImageBitmap(BitmapFactory.decodeFile(img_nhan));
            // imgAnhdaidien.setImageDrawable(Drawable.createFromPath(path));
//            File file = null;
//                file = new File(Environment.getExternalStorageDirectory().getPath(),image);
            Log.d("hinh nhan",file.getAbsolutePath());
//            try {
//                imgAnhdaidien.setImageBitmap(BitmapFactory.decodeStream(new FileInputStream(file)));
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }

        }*/
    }

<<<<<<< HEAD:Code/app/src/main/java/vn/edu/httpgreenacademy/vuivc/Activity/ProfileUser_Activity.java
=======

//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        getFragmentManager().putFragment(outState,FragmentUserMain.class.getName(),fragmentUserMain);
//    }


>>>>>>> beefe2283a34784b2a1f08cdbc25c03d40cfed40:Code/app/src/main/java/vn/edu/httpgreenacademy/vuivc/Fragment/ProfileUser/FragmentUserMain.java
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgbtn_setting:
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(), imgbtn_setting);
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
                            case R.id.itfavourite:
                                ChuyenFragment(new FragmentYeuThich());
                                break;
                            case R.id.logout:
                                AlertDialog.Builder logout_dialog = new AlertDialog.Builder(getApplicationContext());
                                logout_dialog.setMessage("Do you want to log out ?");
                                logout_dialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                logout_dialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        CheckIDLogin(ID_LOGIN);
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
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_button_setting);
                imgbtn_setting.startAnimation(animation);
                break;
            case R.id.line1:
                //ChuyenFragment(fragmentdsVideos);
                break;
            case R.id.line2:
                //ChuyenFragment(fragmentDanhSachFollowers);
                break;
            case R.id.line3:
                //ChuyenFragment(fragmentDanhSachFollowing);
                break;
        }

    }

    private void CheckIDLogin(int id_login) {
        switch (id_login) {
            case 1:
                LoginManager.getInstance().logOut();
                getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new FragmentLogin()).commit();
                finish();
                break;
            default:
                break;
        }
    }
        private void ChuyenFragment (Fragment fragment){
            getSupportFragmentManager().beginTransaction().add(android.R.id.content, fragment,"editprofile").addToBackStack("back").commit();

        }


        @Override
        public void GetSoluongVideo(int soluong) {
            SoLuongVideo = soluong;
        }


        @Override
        public void GetSoluongFollower(int soluong) {
            SoluongFollower =soluong;
        }

        @Override
        public void GetSoluongFollowing(int soluong) {
            SoLuongFollowing = soluong;
        }

        @Override
        public void GetDuLieuEditProfile(ProfileUser profileUser) {
            if(profileUser != null)
            {
                if(profileUser.getPhoto() != null) {
                    imgAnhdaidien.setImageBitmap(profileUser.getPhoto());
                }
                else
                    imgAnhdaidien.setImageResource(R.drawable.user);
                txtTenUser.setText(profileUser.getNameUser().toString()+"");
                txtSex.setText(profileUser.isSex().toString());
                txtDate.setText(profileUser.getNgaySinh().toString());
            }
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        FragmentEditProfile fragmentEditProfile = (FragmentEditProfile) getSupportFragmentManager().findFragmentByTag("editprofile");
        if(fragmentEditProfile != null)
        {
            fragmentEditProfile.onActivityResult(requestCode,resultCode,data);
        }

    }
}


