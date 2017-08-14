package com.mursitaffandi.erporatebootcamptest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ErporatePariwisata implements Parcelable {
    String nama_pariwisata, alamat_pariwisata, detail_pariwisata, gambar_pariwisata;

    public ErporatePariwisata() {
    }

    public ErporatePariwisata(String nama_pariwisata, String alamat_pariwisata, String detail_pariwisata, String gambar_pariwisata) {
        this.nama_pariwisata = nama_pariwisata;
        this.alamat_pariwisata = alamat_pariwisata;
        this.detail_pariwisata = detail_pariwisata;
        this.gambar_pariwisata = gambar_pariwisata;
    }

    public String getNama_pariwisata() {
        return nama_pariwisata;
    }

    public void setNama_pariwisata(String nama_pariwisata) {
        this.nama_pariwisata = nama_pariwisata;
    }

    public String getAlamat_pariwisata() {
        return alamat_pariwisata;
    }

    public void setAlamat_pariwisata(String alamat_pariwisata) {
        this.alamat_pariwisata = alamat_pariwisata;
    }

    public String getDetail_pariwisata() {
        return detail_pariwisata;
    }

    public void setDetail_pariwisata(String detail_pariwisata) {
        this.detail_pariwisata = detail_pariwisata;
    }

    public String getGambar_pariwisata() {
        return gambar_pariwisata;
    }

    public void setGambar_pariwisata(String gambar_pariwisata) {
        this.gambar_pariwisata = gambar_pariwisata;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama_pariwisata);
        dest.writeString(this.alamat_pariwisata);
        dest.writeString(this.detail_pariwisata);
        dest.writeString(this.gambar_pariwisata);
    }

    protected ErporatePariwisata(Parcel in) {
        this.nama_pariwisata = in.readString();
        this.alamat_pariwisata = in.readString();
        this.detail_pariwisata = in.readString();
        this.gambar_pariwisata = in.readString();
    }

    public static final Parcelable.Creator<ErporatePariwisata> CREATOR = new Parcelable.Creator<ErporatePariwisata>() {
        @Override
        public ErporatePariwisata createFromParcel(Parcel source) {
            return new ErporatePariwisata(source);
        }

        @Override
        public ErporatePariwisata[] newArray(int size) {
            return new ErporatePariwisata[size];
        }
    };
}
