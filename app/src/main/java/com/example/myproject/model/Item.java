package com.example.myproject.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    private int id;
    private String name;
    private String code;
    private int stok = 0;

    public Item() {
    }

    public Item(int id, String name, String code, int stok) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.stok = stok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.code);
        dest.writeInt(this.stok);
    }

    protected Item(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.code = in.readString();
        this.stok = in.readInt();
    }

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

}
