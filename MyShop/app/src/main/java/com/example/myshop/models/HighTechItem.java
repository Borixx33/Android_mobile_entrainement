package com.example.myshop.models;

public class HighTechItem {

    //fields
    private String name;
    private String mnemonic;
    private double price;


    //Constructor
    public HighTechItem(String name, String mnemonic, double price){
        this.name = name;
        this.mnemonic = mnemonic;
        this.price = price;

    }

    //Methods

    public String getName(){ return name; }

    public String getMnemonic(){ return mnemonic; }

    public double getPrice(){ return price; }
}
