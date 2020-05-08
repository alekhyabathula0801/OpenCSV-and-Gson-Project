package com.opencsvandgsonproject;

import com.opencsv.bean.CsvBindByName;

public class CSVUser {
    @CsvBindByName
    private String name;

    @CsvBindByName(column = "email", required = true)
    private String email;

    @CsvBindByName(column = "phone")
    private String phoneNum;

    @CsvBindByName
    private String country;

    public CSVUser(String name, String email, String phoneNum, String country) {
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.country = country;
    }

    public CSVUser() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {

        return name + "," + email + "," + phoneNum + "," + country;
    }
}
