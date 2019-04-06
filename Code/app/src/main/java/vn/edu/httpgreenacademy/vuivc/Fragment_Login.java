package vn.edu.httpgreenacademy.vuivc;

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

public class Fragment_Login extends Fragment implements View.OnClickListener,Login_Status{
    TextView Txt_Error;
    EditText Ed_UserName, Ed_Password;
    Button Bt_Login,Bt_Register,Bt_Home_Login;

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

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.BT_Login_Login:
                Login_ASyctask login_aSyctask = new Login_ASyctask( this);
                login_aSyctask.execute(Ed_UserName.getText().toString(),Ed_Password.getText().toString());
                break;
            case R.id.BT_Register_Login:
                Fragment_Register fragment_register = new Fragment_Register();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(android.R.id.content,fragment_register).addToBackStack("s").commit();
                break;
            case R.id.Bt_Home_Login:
                Fragment_Home fragment_home = new Fragment_Home();
                FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                fragmentManager1.beginTransaction().replace(android.R.id.content,fragment_home).commit();
                break;
        }
    }

    @Override
    public void LoginStatus(Boolean isThanhCong) {
        if(isThanhCong)
        {
            Txt_Error.setText(getResources().getString(R.string.Thanhcong));
        }
        else
        {
            Txt_Error.setText(getResources().getString(R.string.Error));
        }

    }
}
