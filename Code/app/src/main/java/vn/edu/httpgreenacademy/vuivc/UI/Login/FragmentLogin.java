package vn.edu.httpgreenacademy.vuivc.UI.Login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import vn.edu.httpgreenacademy.vuivc.Fragment.Home.HomeFragment;
import vn.edu.httpgreenacademy.vuivc.Utils.Interface.Login_Status;
import vn.edu.httpgreenacademy.vuivc.R;

public class FragmentLogin extends Fragment implements  Login_Status {
    TextView Txt_Error;

    LoginButton btnloginfacebook;
    CallbackManager callbackManager;
    int KIEM_TRA_DANG_NHAP;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);


        btnloginfacebook = view.findViewById(R.id.btn_login_facebook);
        btnloginfacebook.setReadPermissions("email", "public_profile");
        btnloginfacebook.setFragment(this);
/*
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
        LoginManager.getInstance().logOut();*/

        return view;
    }


    @Override
    public void LoginStatus(Boolean isThanhCong) {
        if (isThanhCong) {
            Txt_Error.setText(getResources().getString(R.string.Thanhcong));
            HomeFragment homeFragment = new HomeFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(android.R.id.content,homeFragment).commit();
        } else {
            callbackManager = CallbackManager.Factory.create(); // xử lý các phản hồi đăng nhập
            btnloginfacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    String token = loginResult.getAccessToken().getToken();
                    Toast.makeText(getContext(), "Success", Toast.LENGTH_LONG).show();

                }

                @Override
                public void onCancel() {

                }

                @Override
                public void onError(FacebookException error) {

                }
            });
        }
    }
}
