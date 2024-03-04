package com.example.demo.weatherInfo.controller;

import java.util.ArrayList;

import lombok.ToString;


@ToString
class TempBody{
    public String dataType;
    public TempItems items;
    public int pageNo;
    public int numOfRows;
    public int totalCount;
}
@ToString
class TempHeader{
    public String resultCode;
    public String resultMsg;
}
@ToString
class TempItem{
    public String regId;
    public int taMin3;
    public int taMin3Low;
    public int taMin3High;
    public int taMax3;
    public int taMax3Low;
    public int taMax3High;
    public int taMin4;
    public int taMin4Low;
    public int taMin4High;
    public int taMax4;
    public int taMax4Low;
    public int taMax4High;
    public int taMin5;
    public int taMin5Low;
    public int taMin5High;
    public int taMax5;
    public int taMax5Low;
    public int taMax5High;
    public int taMin6;
    public int taMin6Low;
    public int taMin6High;
    public int taMax6;
    public int taMax6Low;
    public int taMax6High;
    public int taMin7;
    public int taMin7Low;
    public int taMin7High;
    public int taMax7;
    public int taMax7Low;
    public int taMax7High;
    public int taMin8;
    public int taMin8Low;
    public int taMin8High;
    public int taMax8;
    public int taMax8Low;
    public int taMax8High;
    public int taMin9;
    public int taMin9Low;
    public int taMin9High;
    public int taMax9;
    public int taMax9Low;
    public int taMax9High;
    public int taMin10;
    public int taMin10Low;
    public int taMin10High;
    public int taMax10;
    public int taMax10Low;
    public int taMax10High;
}
@ToString
class TempItems{
    public ArrayList<TempItem> item;
}
@ToString
class TempResponse{
    public TempHeader header;
    public TempBody body;
}
@ToString
class TempRoot{
    public TempResponse response;
}

