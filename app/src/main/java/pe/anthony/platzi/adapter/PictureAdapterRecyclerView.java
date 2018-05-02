package pe.anthony.platzi.adapter;

import android.app.Activity;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import pe.anthony.platzi.R;
import pe.anthony.platzi.model.Picture;
import pe.anthony.platzi.view.PictureDetailActivity;

/**
 * Created by ANTHONY on 30/10/2017.
 */

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureViewHolder> {

    private ArrayList<Picture> pictures;
    private int resource;
    private Activity activity;//Recomienda para guiarnos al momento de traer la imagen de internet

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        /*Aqui se da el paso de datos de los objetos en este caso de picture
        * aqui tambien se va generando la lista de forma que vamos recorriendo con el scroll*/

        Picture picture = pictures.get(position);
        holder.usernameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText(picture.getLike_number());
        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCard);

        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);

                /*Estos son para efectos de transiciones, recuerda que solo es posible para dispositivos a partir de android 5
                Hay 3 efectos muy conocidos, explote,slide,fake
                este efecto se ponen justo donde la imagen set el onclickListiner porque es ahi en ese momento que estamos declarando
                el cambio de intent*/
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new Explode();
                    explode.setDuration(1000); //esta es en millisegundos
                    activity.getWindow().setExitTransition(explode); //Ahora tienes que asignar el evento de salida
                    activity.startActivity(intent,
                            ActivityOptionsCompat.makeSceneTransitionAnimation(activity, view, activity.getString(R.string.transitionname_picture)).toBundle());
                    //ese startActivity tendra mas valores porque colocamos el efecto de la animacion, ademas se tiene que colocar el string de la
//                    transicion

                }else {
                    activity.startActivity(intent);
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }
}
