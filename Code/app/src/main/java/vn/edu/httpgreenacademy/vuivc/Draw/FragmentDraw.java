package vn.edu.httpgreenacademy.vuivc.Draw;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import vn.edu.httpgreenacademy.vuivc.R;

public class FragmentDraw extends Fragment implements View.OnClickListener {

    Button btloadimgsv,btloadimgphone,btbackhome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentdraw, container, false);

        btbackhome = view.findViewById(R.id.btbackhome);
        btloadimgphone = view.findViewById(R.id.btloadimgphone);
        btloadimgsv = view.findViewById(R.id.btloadimgsv);

        btloadimgsv.setOnClickListener(this);
        btloadimgphone.setOnClickListener(this);
        btbackhome.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btbackhome:
                getActivity().onBackPressed();
                break;
            case R.id.btloadimgphone:
                FragmentEditPick fragmentEditPick = new FragmentEditPick();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(android.R.id.content,fragmentEditPick).addToBackStack("s").commit();
                break;
            case R.id.btloadimgsv:
                FragmentPickAVUICC fragmentPickAVUICC = new FragmentPickAVUICC();
                FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                fragmentManager1.beginTransaction().replace(android.R.id.content,fragmentPickAVUICC).addToBackStack("s").commit();
                break;
        }
    }
}
