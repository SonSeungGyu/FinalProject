package com.example.demo.matching.controller;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
class SkyBody{
    public String dataType;
    public SkyItems items;
    public int pageNo;
    public int numOfRows;
    public int totalCount;
}
@ToString
@Setter
@Getter
class SkyHeader{
    public String resultCode;
    public String resultMsg;
}
@ToString
@Setter
@Getter
class SkyItem{
    public String regId;
    public int rnSt3Am;
    public int rnSt3Pm;
    public int rnSt4Am;
    public int rnSt4Pm;
    public int rnSt5Am;
    public int rnSt5Pm;
    public int rnSt6Am;
    public int rnSt6Pm;
    public int rnSt7Am;
    public int rnSt7Pm;
    public int rnSt8;
    public int rnSt9;
    public int rnSt10;
    public String wf3Am;
    public String wf3Pm;
    public String wf4Am;
    public String wf4Pm;
    public String wf5Am;
    public String wf5Pm;
    public String wf6Am;
    public String wf6Pm;
    public String wf7Am;
    public String wf7Pm;
    public String wf8;
    public String wf9;
    public String wf10;
    public String wf3PmImg;
    public String wf4PmImg;
    public String wf5PmImg;
}
@ToString
@Setter
@Getter
class SkyItems{
    public ArrayList<SkyItem> item;
}
@ToString
@Setter
@Getter
class SkyResponse{
    public SkyHeader header;
    public SkyBody body;
}
@ToString
@Setter
@Getter
class SkyRoot{
    public SkyResponse response;
}

