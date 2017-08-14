package com.mursitaffandi.erporatebootcamptest;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mursitaffandi.erporatebootcamptest.adapter.List_erporate_adapter;
import com.mursitaffandi.erporatebootcamptest.model.ErporatePariwisata;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerViewMain;
    List<ErporatePariwisata>  erporatePariwisata = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerViewMain = (RecyclerView)findViewById(R.id.rvMain);
        new GetDataErporate(recyclerViewMain, this).execute("http://www.erporate.com/bootcamp/jsonBootcamp.php");
    }

    private class GetDataErporate extends AsyncTask<String, Void, String> {
        RecyclerView recyclerView;
        Context mContext;

        public GetDataErporate(RecyclerView recyclerView, Context mContext) {
            this.recyclerView = recyclerView;
        }

        @Override
        protected String doInBackground(String... strings) {
            String response = "";
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                InputStream stream = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
                StringBuilder builder = new StringBuilder();

                String inputString;
                while ((inputString = bufferedReader.readLine()) != null) {
                    builder.append(inputString);
                }
                response = builder.toString();
                urlConnection.disconnect();
            } catch (IOException  e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String json) {
            if (!json.equals("")){
                try {
                    JSONObject topLevel = new JSONObject(json);
                    JSONArray data = topLevel.getJSONArray("data");
                    for (int i = 0; i < data.length(); i++){
                        JSONObject insideData = data.getJSONObject(i);
                        ErporatePariwisata erporatePariwisataJSON = new ErporatePariwisata();
                        erporatePariwisataJSON.setNama_pariwisata(insideData.getString("nama_pariwisata"));
                        erporatePariwisataJSON.setAlamat_pariwisata(insideData.getString("alamat_pariwisata"));
                        erporatePariwisataJSON.setDetail_pariwisata(insideData.getString("detail_pariwisata"));
                        erporatePariwisataJSON.setGambar_pariwisata(insideData.getString("gambar_pariwisata"));

                        erporatePariwisata.add(erporatePariwisataJSON);
                    }
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
                    recyclerView.setLayoutManager(linearLayoutManager);

                    List_erporate_adapter mainAdapterItem = new List_erporate_adapter(getApplicationContext(), erporatePariwisata);
                    recyclerView.setAdapter(mainAdapterItem);

                }catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
