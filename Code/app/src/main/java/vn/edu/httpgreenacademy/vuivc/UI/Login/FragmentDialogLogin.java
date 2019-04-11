package vn.edu.httpgreenacademy.vuivc.UI.Login;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import vn.edu.httpgreenacademy.vuivc.Network.Login_ASyctask;
import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.Utils.Interface.Login_Status;

public class FragmentDialogLogin extends Fragment implements View.OnClickListener, Login_Status {
    TextView txtError;
    EditText edUserName, edPassword;
    Button btLogin, btRegister;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_login, container, false);

        edUserName = view.findViewById(R.id.Ed_UserName_Login);
        edPassword = view.findViewById(R.id.Ed_Password_Login);
        btLogin = view.findViewById(R.id.BT_Login_Login);
        btRegister = view.findViewById(R.id.BT_Register);
        txtError = view.findViewById(R.id.TXT_Error);

        btRegister.setOnClickListener(this);
        btLogin.setOnClickListener(this);


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
                Login_ASyctask login_aSyctask = new Login_ASyctask(this);
                login_aSyctask.execute(edUserName.getText().toString(), edPassword.getText().toString());
                break;
            case R.id.BT_Register:
                FragmentRegister fragment_register = new FragmentRegister();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(android.R.id.content, fragment_register).addToBackStack("s").commit();
                break;
        }
    }

    @Override
    public void LoginStatus(Boolean isThanhCong) {
        if (isThanhCong) {
            txtError.setText(getResources().getString(R.string.Thanhcong));
        } else {
            txtError.setText(getResources().getString(R.string.Error));
        }
    }
}
