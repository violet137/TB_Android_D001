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
import vn.edu.httpgreenacademy.vuivc.Network.Register_AsycnTask;
import vn.edu.httpgreenacademy.vuivc.Utils.Interface.Register_Statis;

public class FragmentRegister extends Fragment implements View.OnClickListener, Register_Statis {

    EditText edUserName,Ed_Password;
    Button btRegister, btBack, btHomeRegister;
    TextView txtErrorRegister;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        Ed_Password = view.findViewById(R.id.Ed_Password_Register);
        edUserName = view.findViewById(R.id.Ed_UserName_Resgister);
        btBack = view.findViewById(R.id.BT_Back_Register);
        btRegister = view.findViewById(R.id.Bt_Register_Register);
        btHomeRegister = view.findViewById(R.id.BT_Home_Register);
        txtErrorRegister = view.findViewById(R.id.Txt_Error_Register);

        btRegister.setOnClickListener(this);
        btBack.setOnClickListener(this);
        btHomeRegister.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.Bt_Register_Register:
                Register_AsycnTask register_asycnTask = new Register_AsycnTask(this);
                register_asycnTask.execute(edUserName.getText().toString(),Ed_Password.getText().toString());
                break;
            case R.id.BT_Back_Register:
                getActivity().onBackPressed();
                break;
            case R.id.BT_Home_Register:
                FragmentHomelogin fragment_home = new FragmentHomelogin();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment,fragment_home).commit();
                break;
        }
    }

    @Override
    public void RegisterStatus(Boolean isThanhCong) {
        if(isThanhCong)
        {
            FragmentLogin fragment_login = new FragmentLogin();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment,fragment_login).commit();
        }
        else
        {
            txtErrorRegister.setText(getResources().getString(R.string.Error_Register));
        }

    }
}
