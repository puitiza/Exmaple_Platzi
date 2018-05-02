package pe.anthony.platzi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import pe.anthony.platzi.R;

/**
 * Created by ANTHONY on 30/10/2017.
 */

public class PictureViewHolder extends RecyclerView.ViewHolder {

    public ImageView pictureCard;
    public TextView usernameCard;
    public TextView timeCard;
    public TextView likeNumberCard;

    public PictureViewHolder(View itemView) {
        super(itemView);

        pictureCard     = (ImageView) itemView.findViewById(R.id.pictureCard);
        usernameCard    = (TextView) itemView.findViewById(R.id.usernameCard);
        timeCard        = (TextView) itemView.findViewById(R.id.timeCard);
        likeNumberCard  = (TextView) itemView.findViewById(R.id.likeNumberCard);
    }
}
