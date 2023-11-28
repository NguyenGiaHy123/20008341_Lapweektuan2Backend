package com.example.nguyengiahy20008341labweektuan2.models;

public enum IProductStatus {
    ACTIVE(1),
    IN_ACTIVE(0),
    TERMINATED(-1);
    private int value;


    public int getValue() {
        return value;
    }

    IProductStatus(int value) {
        this.value = value;
    }
}
