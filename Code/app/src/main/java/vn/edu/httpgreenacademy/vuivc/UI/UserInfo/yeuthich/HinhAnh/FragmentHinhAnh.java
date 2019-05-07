package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.HinhAnh;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.R;

public class FragmentHinhAnh extends Fragment {
    RecyclerView List_YeuThich_HinhAnh;
    ArrayList<HinhAnhModel> datahinhanh = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hinhanh, container, false);
        List_YeuThich_HinhAnh = view.findViewById(R.id.List_Yeuthich_HinhAnh);
        List_YeuThich_HinhAnh.setHasFixedSize(true);
        datahinhanh.clear();
        TypedArray hinhanh = getResources().obtainTypedArray(R.array.hinhanh);
        for(int i =0;i<hinhanh.length();i++)
        {
            HinhAnhModel hinhAnh_model = new HinhAnhModel(hinhanh.getResourceId(i,-1));
            datahinhanh.add(hinhAnh_model);
        }

        HinhAnhAdapter hinhAnh_adapter = new HinhAnhAdapter(datahinhanh,getActivity());
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        List_YeuThich_HinhAnh.setLayoutManager(gridLayoutManager);
        List_YeuThich_HinhAnh.setAdapter(hinhAnh_adapter);


        return view;
    }
}
