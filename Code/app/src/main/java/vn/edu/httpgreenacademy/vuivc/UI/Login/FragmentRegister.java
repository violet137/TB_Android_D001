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

import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.Network.RegisterAsycnTask;
import vn.edu.httpgreenacademy.vuivc.Utils.Interface.Register_Statis;

public class FragmentRegister extends Fragment implements View.OnClickListener, Register_Statis {

    EditText Ed_UserName,Ed_Password;
    Button Bt_Register,Bt_Back,Bt_Home_Register;
    TextView Txt_Error_Register;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        Ed_Password = view.findViewById(R.id.Ed_Password_Register);
        Ed_UserName = view.findViewById(R.id.Ed_UserName_Resgister);
        Bt_Back = view.findViewById(R.id.BT_Back_Register);
        Bt_Register = view.findViewById(R.id.Bt_Register_Register);
        Bt_Home_Register = view.findViewById(R.id.BT_Home_Register);
        Txt_Error_Register = view.findViewById(R.id.Txt_Error_Register);

        Bt_Register.setOnClickListener(this);
        Bt_Back.setOnClickListener(this);
        Bt_Home_Register.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.Bt_Register_Register:
                RegisterAsycnTask register_asycnTask = new RegisterAsycnTask(this);
                register_asycnTask.execute(Ed_UserName.getText().toString(),Ed_Password.getText().toString());
                break;
            case R.id.BT_Back_Register:
                getActivity().onBackPressed();
                break;
            case R.id.BT_Home_Register:
                FragmentHome fragment_home = new FragmentHome();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(android.R.id.content,fragment_home).commit();
                break;
        }
    }

    @Override
    public void RegisterStatus(Boolean isThanhCong) {
        if(isThanhCong)
        {
            FragmentLogin fragment_login = new FragmentLogin();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(android.R.id.content,fragment_login).commit();
        }
        else
        {
            Txt_Error_Register.setText(getResources().getString(R.string.Error_Register));
        }

    }
}
