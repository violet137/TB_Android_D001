package vn.edu.httpgreenacademy.vuivc.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import vn.edu.httpgreenacademy.vuivc.ModelUser.Followers;
import vn.edu.httpgreenacademy.vuivc.R;

public class ViewHolder_Followers extends RecyclerView.ViewHolder {
    ImageView img_follower;
    TextView txt_idfollower,txt_tenfollower;
    public ViewHolder_Followers(View itemView) {
        super(itemView);
        img_follower = itemView.findViewById(R.id.img_follower);
        txt_idfollower = itemView.findViewById(R.id.txt_id_follower);
        txt_tenfollower = itemView.findViewById(R.id.txt_tenfollwer);
    }
    public void SetData(Followers followers)
    {
        img_follower.setImageResource(followers.getImg());
        txt_tenfollower.setText(followers.getTen()+"");
        txt_idfollower.setText(followers.getID()+"");
    }
}
