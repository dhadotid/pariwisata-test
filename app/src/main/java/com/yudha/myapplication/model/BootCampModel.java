package com.yudha.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BootCampModel implements Parcelable {

    String namaPariwisata;
    String alamatPariwisata;
    String detailPariwisata;
    String gambarPariwisata;

    public BootCampModel(String namaPariwisata, String alamatPariwisata,
                         String detailPariwisata, String gambarPariwisata) {
        this.namaPariwisata = namaPariwisata;
        this.alamatPariwisata = alamatPariwisata;
        this.detailPariwisata = detailPariwisata;
        this.gambarPariwisata = gambarPariwisata;
    }

    public String getNamaPariwisata() {
        return namaPariwisata;
    }

    public String getAlamatPariwisata() {
        return alamatPariwisata;
    }

    public String getDetailPariwisata() {
        return detailPariwisata;
    }

    public String getGambarPariwisata() {
        return gambarPariwisata;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.namaPariwisata);
        dest.writeString(this.alamatPariwisata);
        dest.writeString(this.detailPariwisata);
        dest.writeString(this.gambarPariwisata);
    }

    protected BootCampModel(Parcel in) {
        this.namaPariwisata = in.readString();
        this.alamatPariwisata = in.readString();
        this.detailPariwisata = in.readString();
        this.gambarPariwisata = in.readString();
    }

    public static final Parcelable.Creator<BootCampModel> CREATOR = new Parcelable.Creator<BootCampModel>() {
        @Override
        public BootCampModel createFromParcel(Parcel source) {
            return new BootCampModel(source);
        }

        @Override
        public BootCampModel[] newArray(int size) {
            return new BootCampModel[size];
        }
    };
}
