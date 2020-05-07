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

    @Override
    public String toString() {
        return "CSVUser{" + "name = '" + name + '\'' + ", email = '" + email +
                '\'' + ", phone number = '" + phoneNum +
                '\'' +", country = '" + country + '\'' + "}";
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
}
