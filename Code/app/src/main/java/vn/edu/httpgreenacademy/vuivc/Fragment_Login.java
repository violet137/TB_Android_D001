package vn.edu.httpgreenacademy.vuivc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class Fragment_Login extends Fragment {
    LoginButton btn_login_facebook;
    CallbackManager callbackManager;
    int KIEM_TRA_DANG_NHAP;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        btn_login_facebook = view.findViewById(R.id.btn_login_facebook);
        btn_login_facebook.setReadPermissions("email", "public_profile");
        btn_login_facebook.setFragment(this);
/*
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
        LoginManager.getInstance().logOut();*/

        callbackManager = CallbackManager.Factory.create(); // xử lý các phản hồi đăng nhập
        btn_login_facebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
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

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
