package com.example.nguyengiahy20008341labweektuan2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name="id_user",columnDefinition = "int")
    private long id;
    private String name;
    private String password;
    private KindOfUser kinofuser;

    public User(String name, String password, KindOfUser kinofuser) {
        this.name = name;
        this.password = password;
        this.kinofuser = kinofuser;
    }

    public User() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setKinofuser(KindOfUser kinofuser) {
        this.kinofuser = kinofuser;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public KindOfUser getKinofuser() {
        return kinofuser;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", kinofuser=" + kinofuser +
                '}';
    }
}
