package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vn.edu.httpgreenacademy.vuivc.R;

public class FragmentVideo extends Fragment {
    RecyclerView List_YeuThich_Video;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        List_YeuThich_Video = view.findViewById(R.id.List_Yeuthich_Video);

        return view;
    }
}
