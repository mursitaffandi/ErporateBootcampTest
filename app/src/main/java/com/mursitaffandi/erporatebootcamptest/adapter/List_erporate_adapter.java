package com.mursitaffandi.erporatebootcamptest.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mursitaffandi.erporatebootcamptest.DetailWisataActivity;
import com.mursitaffandi.erporatebootcamptest.R;
import com.mursitaffandi.erporatebootcamptest.model.ErporatePariwisata;
import com.mursitaffandi.erporatebootcamptest.utils.RenderImage;

import java.util.List;

/**
 * Created by mursitaffandi on 13/08/17.
 */

public class List_erporate_adapter extends RecyclerView.Adapter<HoderItem> {
    Context context;
    List<ErporatePariwisata> listitemObjects;

    public List_erporate_adapter(Context context, List<ErporatePariwisata> listitemObjects) {
        this.context = context;
        this.listitemObjects = listitemObjects;
    }

    @Override
    public HoderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, null);
        HoderItem holderItem = new HoderItem(view);
        return holderItem;
    }

    @Override
    public void onBindViewHolder(HoderItem holder, final int position) {
        holder.tvJudul.setText(listitemObjects.get(position).getNama_pariwisata());
        new RenderImage(holder.imgVIcon).execute(listitemObjects.get(position).getGambar_pariwisata());
        holder.cardItemPlanet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ErporatePariwisata dataForDetail = listitemObjects.get(position);
                Intent toDetail = new Intent(context, DetailWisataActivity.class);
                toDetail.putExtra("data", dataForDetail);
                v.getContext().startActivity(toDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listitemObjects.size();
    }
}
