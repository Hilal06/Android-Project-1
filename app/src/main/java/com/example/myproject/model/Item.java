package com.example.myproject.model;

public class Item {
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
}
