package vn.edu.httpgreenacademy.vuivc.Draw;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.R;

public class PickAdapter extends RecyclerView.Adapter<PickViewHodel> {
    ArrayList<PickModel> pickModelArrayList = new ArrayList<>();
    Activity activity;
    FragmentEditPick fragmentEditPick;
    PickImageInterface pickImageInterface;
    Context context;
    public PickAdapter(ArrayList<PickModel> pickModelArrayList, Activity activity, PickImageInterface pickImageInterface,Context context) {
        this.pickModelArrayList = pickModelArrayList;
        this.activity = activity;
        this.pickImageInterface = pickImageInterface;
        this.context = context;
    }

    @NonNull
    @Override
    public PickViewHodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itempickvuivc,viewGroup,false);

        return new PickViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PickViewHodel pickViewHodel, int i) {
        final  PickModel pickModel = pickModelArrayList.get(i);
        pickViewHodel.sethinhanh(pickModel);
        pickViewHodel.itemview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImageInterface.PickImageCallback(pickModel.getDuongdanhinh());
                Toast.makeText(context.getApplicationContext(),
                        "Đã Chọn Ảnh Hãy Nhấn Vào Chỉnh Ảnh",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pickModelArrayList.size();
    }
}
