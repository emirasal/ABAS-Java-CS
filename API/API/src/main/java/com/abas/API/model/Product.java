package com.abas.API.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    @JsonProperty("Siparis")
    private String siparis;

    @JsonProperty("MalNumarasi")
    private int malNumarasi;

    @JsonProperty("Miktar")
    private int miktar;

    @JsonProperty("BirimFiyat")
    private double birimFiyat;


    public Product() {}

    public Product(String siparis, int malNumarasi, int miktar, double birimFiyat) {
        this.siparis = siparis;
        this.malNumarasi = malNumarasi;
        this.miktar = miktar;
        this.birimFiyat = birimFiyat;
    }


    public String getSiparis() {
        return siparis;
    }

    public void setSiparis(String siparis) {
        this.siparis = siparis;
    }

    public int getMalNumarasi() {
        return malNumarasi;
    }

    public void setMalNumarasi(int malNumarasi) {
        this.malNumarasi = malNumarasi;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public double getBirimFiyat() {
        return birimFiyat;
    }

    public void setBirimFiyat(double birimFiyat) {
        this.birimFiyat = birimFiyat;
    }
}