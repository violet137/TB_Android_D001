package vn.edu.httpgreenacademy.vuivc;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogViewHolder extends RecyclerView.ViewHolder {
    ImageView imageViewItem;
    TextView textViewItem;

    public DialogViewHolder(View itemView) {
        super(itemView);

        imageViewItem=itemView.findViewById(R.id.img_dailog);
        textViewItem=itemView.findViewById(R.id.tv_item);
    }

    public void bind(final DialogItem dialogItem)
    {
        int resID = itemView.getContext().getResources().getIdentifier(dialogItem.namePng,
                "drawable", itemView.getContext().getPackageName());
        imageViewItem.setImageResource(resID);
        textViewItem.setText(dialogItem.nameTxt);
    }
}
