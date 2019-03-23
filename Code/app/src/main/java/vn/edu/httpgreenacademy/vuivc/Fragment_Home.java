package vn.edu.httpgreenacademy.vuivc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment_Login extends Fragment implements View.OnClickListener{
    TextView Txt_Google,Txt_Facebook;
    Button Bt_Login,Bt_Register;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        Txt_Facebook = view.findViewById(R.id.Txt_FaceBook);
        Txt_Google = view.findViewById(R.id.Txt_GoogLe);
        Bt_Login = view.findViewById(R.id.Bt_Login);
        Bt_Register = view.findViewById(R.id.Bt_Register);

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
            case R.id.Bt_Login:
                break;
            case R.id.Bt_Register:
                break;
            case R.id.Txt_FaceBook:
                break;
            case R.id.Txt_GoogLe:
                break;
        }
    }
}
