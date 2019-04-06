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

public class Fragment_Home extends Fragment implements View.OnClickListener {
    TextView Txt_Google;
    Button Bt_Login, Bt_Register;

    //facebook
    LoginButton btn_login_facebook;
    CallbackManager callbackManager;
    int KIEM_TRA_DANG_NHAP;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Txt_Google = view.findViewById(R.id.Txt_GoogLe_Home);
        Bt_Login = view.findViewById(R.id.Bt_Login_Home);
        Bt_Register = view.findViewById(R.id.Bt_Register_Home);

        
        btn_login_facebook = view.findViewById(R.id.btn_login_facebook);

        Txt_Google.setOnClickListener(this);
        Bt_Register.setOnClickListener(this);
        Bt_Login.setOnClickListener(this);


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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Bt_Login_Home:
                Fragment_Login fragment_login = new Fragment_Login();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(android.R.id.content, fragment_login).addToBackStack("s").commit();
                break;
            case R.id.Bt_Register_Home:
                Fragment_Register fragment_register = new Fragment_Register();
                FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                fragmentManager1.beginTransaction().replace(android.R.id.content, fragment_register).addToBackStack("s").commit();
                break;
            case R.id.Txt_GoogLe_Home:
                break;
        }
    }
}
