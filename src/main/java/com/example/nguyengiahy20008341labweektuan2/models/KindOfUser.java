package com.example.nguyengiahy20008341labweektuan2.models;

public enum KindOfUser {
    CUSTOMER(0),
    EMPLOYEE(1);
    private int value;
    KindOfUser(int value){
        this.value=value;
    }
    public  int getValue(){
        return value;
    }
}
