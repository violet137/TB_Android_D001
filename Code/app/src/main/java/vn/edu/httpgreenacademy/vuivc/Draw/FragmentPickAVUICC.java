package vn.edu.httpgreenacademy.vuivc.Draw;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.R;

public class FragmentPickAVUICC extends Fragment implements View.OnClickListener, PickImageInterface {
    ImageView imgback;
    Button btokanh;
    RecyclerView listanh;
    ArrayList<PickModel> datahinhanh = new ArrayList<>();
    int HinhAnh;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentpickavuivc, container, false);
        imgback = view.findViewById(R.id.imgBackofPick);
        imgback.setOnClickListener(this);
        listanh = view.findViewById(R.id.listAnhVUIVC);
        btokanh = view.findViewById(R.id.btokanh);
        btokanh.setOnClickListener(this);
        datahinhanh.clear();
        TypedArray hinhanh = getResources().obtainTypedArray(R.array.Anhche);
        String[] tenanh = getResources().getStringArray(R.array.tenanh);
        for (int i = 0; i < tenanh.length; i++) {
            PickModel pickModel = new PickModel(hinhanh.getResourceId(i, -1), tenanh[i]);
            datahinhanh.add(pickModel);
        }


        PickAdapter pickAdapter = new PickAdapter(datahinhanh, getActivity(), this, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        listanh.setLayoutManager(linearLayoutManager);
        listanh.setAdapter(pickAdapter);

        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBackofPick:
                getActivity().onBackPressed();
                break;
            case  R.id.btokanh:
                FragmentEditPick fragmentEditPick = new FragmentEditPick();
                Bundle bundle = new Bundle();
                bundle.putInt("hinhanh", HinhAnh);
                fragmentEditPick.setArguments(bundle);

                FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                fragmentManager1.beginTransaction().replace(android.R.id.content, fragmentEditPick).addToBackStack("s").commit();
                break;
        }
    }

    @Override
    public void PickImageCallback(int idImage) {
        //cho nhan dc data
        HinhAnh = idImage;
    }
}
