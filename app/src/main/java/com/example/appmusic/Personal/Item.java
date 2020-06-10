package com.example.appmusic.Personal;

public class Item {
    private String mFirstLine;

    private String mSecondLine;

    public Item(String firstLine, String secondLine){
        mFirstLine = firstLine;
        mSecondLine = secondLine;
    }

    public String getmFirstLine(){
        return mFirstLine;
    }

    public String getmSecondLine(){
        return mSecondLine;
    }
}