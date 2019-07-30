package com.cowab.objects;

import lombok.Data;

@Data
public class User {

    String email,
            password,
            organisationNumber,
            companyName,
            userName,
            userLastName,
            userMobile,
            address,
            postCode,
            city,
            phone;

    public User(String email, String password, String organisationNumber, String companyName, String userName, String userLastName, String userMobile,
                String address, String postCode, String city, String phone) {
        this.email = email;
        this.password = password;
        this.organisationNumber = organisationNumber;
        this.companyName = companyName;
        this.userName = userName;
        this.userLastName = userLastName;
        this.userMobile = userMobile;
        this.address = address;
        this.postCode = postCode;
        this.city = city;
        this.phone = phone;
    }

    public User(String organisationNumber, String userMobile,
                String address, String postCode, String city, String phone) {
        this.email = "test" + System.currentTimeMillis() + "@test.tt";
        this.password = "q1w2e3r4T";
        this.organisationNumber = organisationNumber;
        this.companyName = "testCompany";
        this.userName = "TestName";
        this.userLastName = "TestLastName";
        this.userMobile = userMobile;
        this.address = address;
        this.postCode = postCode;
        this.city = city;
        this.phone = phone;
    }
}
