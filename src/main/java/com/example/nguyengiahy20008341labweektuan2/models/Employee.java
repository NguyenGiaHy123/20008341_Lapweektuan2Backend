package com.example.nguyengiahy20008341labweektuan2.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="employees")
@NamedQueries(
        @NamedQuery(name = "Employee.findAll", query = "select e from Employee e")
)

public class Employee  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    @JsonProperty("emp_id")
    private long id;
    @Column(name = "full_name", length = 150, nullable = false)
    @JsonProperty("full_name")

    private String fullname;
    @Column(nullable = false)

    private LocalDateTime dob;

    @Column(unique = true, length = 150)
    @JsonProperty("email")

    private String email;
    @Column(length = 15, nullable = false)
    @JsonProperty("phone")
    private String phone;
    @Column(length = 250, nullable = false)
    @JsonProperty("address")
    private String address;
    @Column(columnDefinition = "int",nullable = false)
    @JsonProperty("status")
    private IEmployee status;
    @OneToMany(mappedBy = "employee")
    @JsonProperty("orders")
    private List<Order> orders;

    @OneToOne
    @JoinColumn(name="user")
    @JsonProperty("user")
    private User user;


    public long getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public IEmployee getStatus() {
        return status;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(IEmployee status) {
        this.status = status;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }



    public Employee() {
    }

    public Employee(long id, String fullname, LocalDateTime dob, String email, String phone, String address, IEmployee status, List<Order> orders) {
        this.id = id;
        this.fullname = fullname;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.orders = orders;
    }
    public Employee(String fullname, LocalDateTime dob, String email, String phone, String address, IEmployee status) {
        this.fullname = fullname;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", orders=" + orders +
                '}';
    }
}
