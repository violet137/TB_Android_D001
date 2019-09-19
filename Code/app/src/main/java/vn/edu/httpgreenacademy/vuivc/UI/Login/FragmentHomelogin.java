package vn.edu.httpgreenacademy.vuivc.UI.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import vn.edu.httpgreenacademy.vuivc.R;

public class FragmentHomelogin extends Fragment implements View.OnClickListener {
    TextView txtGoogle,tvTextRegisterBottom;
    Button btLogin;

    //facebook
    LoginButton btnloginfacebook;
    CallbackManager callbackManager;
    int KIEM_TRA_DANG_NHAP;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        txtGoogle = view.findViewById(R.id.txt_GoogLe_Home);
        btLogin = view.findViewById(R.id.btn_Login_Home);
        tvTextRegisterBottom = view.findViewById(R.id.tvTextRegisterBottom);


        btnloginfacebook = view.findViewById(R.id.btn_login_facebook);
        btnloginfacebook.setBackgroundResource(R.drawable.bt_custom);

        txtGoogle.setOnClickListener(this);
        tvTextRegisterBottom.setOnClickListener(this);
        btLogin.setOnClickListener(this);


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


        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Login_Home:
                FragmentDialogLogin fragment_dialogLogin = new FragmentDialogLogin();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(android.R.id.content, fragment_dialogLogin).addToBackStack("s").commit();
                break;
            case R.id.tvTextRegisterBottom:
                FragmentRegister fragment_register = new FragmentRegister();
                FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                fragmentManager1.beginTransaction().replace(android.R.id.content, fragment_register).addToBackStack("s").commit();
                break;
            case R.id.txt_GoogLe_Home:
                break;
        }
    }
}
