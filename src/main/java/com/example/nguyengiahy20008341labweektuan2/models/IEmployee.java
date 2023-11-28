package com.example.nguyengiahy20008341labweektuan2.models;

public enum IEmployee {
    ACTIVE(1),
    IN_ACTIVE(0),
    TERMINATED(-1);
    private int value;

    public int getValue() {
        return value;
    }

    IEmployee(int value) {
        this.value = value;
    }
}
