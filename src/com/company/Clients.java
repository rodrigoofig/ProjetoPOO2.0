package com.company;

import java.io.Serializable;
import java.util.ArrayList;


abstract class Clients implements Serializable {
    private String name;
    private String household;
    private String email;
    private String phoneNum;
    private Date birhtday;


    public Clients() {
    }

    public Clients(String name, String household, String email, String phoneNum, Date birhtday) {
        this.name = name;
        this.household = household;
        this.email = email;
        this.phoneNum = phoneNum;
        this.birhtday = birhtday;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHousehold() {
        return household;
    }

    public void setHousehold(String household) {
        this.household = household;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getBirhtday() {
        return birhtday;
    }

    public void setBirhtday(Date birhtday) {
        this.birhtday = birhtday;
    }


    @Override
    public String toString() {
        return "Clientes{" +
                "name='" + name + '\'' +
                ", household='" + household + '\'' +
                ", email='" + email + '\'' +
                ", phone number='" + phoneNum + '\'' +
                ", birhtday=" + birhtday +
                ", valTrans=" +
                '}';
    }

    abstract double transportValue(double valorPago, ArrayList<Products> list);
}
