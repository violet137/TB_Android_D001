package vn.edu.httpgreenacademy.vuivc.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import vn.edu.httpgreenacademy.vuivc.ModelUser.Following;
import vn.edu.httpgreenacademy.vuivc.R;

public class ViewHolder_Following extends RecyclerView.ViewHolder {
    ImageView img_following;
    TextView txt_idfollowing,txt_tenfollowing;
    public ViewHolder_Following(View itemView) {
        super(itemView);
        img_following = itemView.findViewById(R.id.img_following);
        txt_idfollowing = itemView.findViewById(R.id.txt_id_following);
        txt_tenfollowing = itemView.findViewById(R.id.txt_tenfollwing);
    }
    public void SetData(Following following)
    {
        img_following.setImageResource(following.getImage());
        txt_tenfollowing.setText(following.getTen()+"");
        txt_idfollowing.setText(following.getID()+"");
    }
}
