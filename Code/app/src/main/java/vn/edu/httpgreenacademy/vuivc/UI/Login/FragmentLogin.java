package vn.edu.httpgreenacademy.vuivc.UI.Login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import vn.edu.httpgreenacademy.vuivc.Network.LoginASyctask;
import vn.edu.httpgreenacademy.vuivc.Utils.Interface.Login_Status;
import vn.edu.httpgreenacademy.vuivc.R;

public class FragmentLogin extends Fragment implements View.OnClickListener, Login_Status {
    TextView Txt_Error;
    EditText Ed_UserName, Ed_Password;
    Button Bt_Login, Bt_Register, Bt_Home_Login;
    LoginButton btn_login_facebook;
    CallbackManager callbackManager;
    int KIEM_TRA_DANG_NHAP;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        Ed_UserName = view.findViewById(R.id.Ed_UserName_Login);
        Ed_Password = view.findViewById(R.id.Ed_Password_Login);
        Bt_Login = view.findViewById(R.id.BT_Login_Login);
        Bt_Register = view.findViewById(R.id.BT_Register_Login);
        Bt_Home_Login = view.findViewById(R.id.Bt_Home_Login);
        Txt_Error = view.findViewById(R.id.Txt_Error);

        Bt_Register.setOnClickListener(this);
        Bt_Login.setOnClickListener(this);
        Bt_Home_Login.setOnClickListener(this);

        btn_login_facebook = view.findViewById(R.id.btn_login_facebook);
        btn_login_facebook.setReadPermissions("email", "public_profile");
        btn_login_facebook.setFragment(this);
/*
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
        LoginManager.getInstance().logOut();*/

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BT_Login_Login:
                LoginASyctask login_aSyctask = new LoginASyctask(this);
                login_aSyctask.execute(Ed_UserName.getText().toString(), Ed_Password.getText().toString());
                break;
            case R.id.BT_Register_Login:
                FragmentRegister fragment_register = new FragmentRegister();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(android.R.id.content, fragment_register).addToBackStack("s").commit();
                break;
            case R.id.Bt_Home_Login:
                FragmentHome fragment_home = new FragmentHome();
                FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                fragmentManager1.beginTransaction().replace(android.R.id.content, fragment_home).commit();
                break;
        }
    }

    @Override
    public void LoginStatus(Boolean isThanhCong) {
        if (isThanhCong) {
            Txt_Error.setText(getResources().getString(R.string.Thanhcong));
        } else {
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
        }
    }
}
