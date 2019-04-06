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
import android.widget.TextView;

public class Fragment_Home extends Fragment implements View.OnClickListener{
    TextView Txt_Google,Txt_Facebook;
    Button Bt_Login,Bt_Register;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Txt_Facebook = view.findViewById(R.id.Txt_FaceBook_Home);
        Txt_Google = view.findViewById(R.id.Txt_GoogLe_Home);
        Bt_Login = view.findViewById(R.id.Bt_Login_Home);
        Bt_Register = view.findViewById(R.id.Bt_Register_Home);

        Txt_Google.setOnClickListener(this);
        Txt_Facebook.setOnClickListener(this);
        Bt_Register.setOnClickListener(this);
        Bt_Login.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.Bt_Login_Home:
                Fragment_Login fragment_login = new Fragment_Login();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(android.R.id.content,fragment_login).addToBackStack("s").commit();
                break;
            case R.id.Bt_Register_Home:
                Fragment_Register fragment_register = new Fragment_Register();
                FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                fragmentManager1.beginTransaction().replace(android.R.id.content,fragment_register).addToBackStack("s").commit();
                break;
            case R.id.Txt_FaceBook_Home:
                break;
            case R.id.Txt_GoogLe_Home:
                break;
        }
    }
}
