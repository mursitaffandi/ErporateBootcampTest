package com.mursitaffandi.erporatebootcamptest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.CardView;

import com.mursitaffandi.erporatebootcamptest.R;

/**
 * Created by mursitaffandi on 13/08/17.
 */

public class HoderItem extends RecyclerView.ViewHolder{
    public TextView tvJudul;
    public ImageView imgVIcon;
    public CardView cardItemPlanet;

    public HoderItem(View itemView) {
        super(itemView);
        tvJudul = (TextView)itemView.findViewById(R.id.txtItemJudul);
        cardItemPlanet = (CardView)itemView.findViewById(R.id.cardItemPlanet);
        imgVIcon = (ImageView) itemView.findViewById(R.id.imgItemIcon);
    }
}

