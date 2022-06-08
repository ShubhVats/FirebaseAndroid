package com.example.assignment.Models;

public class RecyclerView_Model {
    String Text1;
    String Text2;
    String Text3;

    public RecyclerView_Model(String text1, String text2, String text3) {
        Text1 = text1;
        Text2 = text2;
        Text3 = text3;
    }

    public String getText1() {
        return Text1;
    }

    public void setText1(String text1) {
        Text1 = text1;
    }

    public String getText2() {
        return Text2;
    }

    public void setText2(String text2) {
        Text2 = text2;
    }

    public String getText3() {
        return Text3;
    }

    public void setText3(String text3) {
        Text3 = text3;
    }
}
