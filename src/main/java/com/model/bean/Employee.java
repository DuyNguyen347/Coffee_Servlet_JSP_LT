package com.model.bean;

import java.sql.Timestamp;

public class Employee {
    private String id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private Timestamp birthday;
    private String username;
    private String password;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Employee(String id, String name, String address,String email,String phone,Timestamp birthday,String username,String password ) {
        super();
        this.id = id;
       this.name = name;
       this.address = address;
       this.email = email;
       this.phone = phone;
       this.birthday = birthday;
       this.username = username;
       this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
