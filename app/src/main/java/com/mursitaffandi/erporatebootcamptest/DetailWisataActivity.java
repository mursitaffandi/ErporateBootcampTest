package com.mursitaffandi.erporatebootcamptest;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mursitaffandi.erporatebootcamptest.model.ErporatePariwisata;
import com.mursitaffandi.erporatebootcamptest.utils.RenderImage;

public class DetailWisataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        ErporatePariwisata inDetail = getIntent().getParcelableExtra("data");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
            new RenderImage((ImageView) findViewById(R.id.iv_detail_header_parallax)).execute(inDetail.getGambar_pariwisata());
        }

        collapsingToolbarLayout.setTitle(inDetail.getNama_pariwisata());
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBarPlus1);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBarPlus1);

        TextView ed = (TextView)findViewById(R.id.detail);
        ed.setText(inDetail.getDetail_pariwisata());
        TextView ep = (TextView) findViewById(R.id.alamat);
        ep.setText(inDetail.getAlamat_pariwisata());
    }
}
