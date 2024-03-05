package com.example.demo.matching.controller;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
class Body{
 public String dataType;
 public Items items;
 public int pageNo;
 public int numOfRows;
 public int totalCount;
}

@ToString
@Setter
@Getter
class Header{
 public String resultCode;
 public String resultMsg;
}

@ToString
@Setter
@Getter
class Item{
 public Object announceTime;
 public int numEf;
 public String regId;
 public int rnSt;
 public int rnYn;
 public String ta;
 public String wd1;
 public String wd2;
 public String wdTnd;
 public String wf;
 public String wfCd;
 public String wsIt;
 public String img;
}

@ToString
@Setter
@Getter
class Items{
 public ArrayList<Item> item;
}

@ToString
@Setter
@Getter
class Response{
 public Header header;
 public Body body;
}

@ToString
@Setter
@Getter
class Root{
 public Response response;
}
