package jk.uz.pdp.model;

import java.util.UUID;

public class User extends BaseModel {
    private String phoneNumber;
    private String fullName;
    private String username;
    private int smsCode;

    public User(String phoneNumber, String fullName, String username, int smsCode) {
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.username = username;
        this.smsCode = smsCode;
    }


    public User(String phoneNumber, String fullName, int smsCode) {
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.smsCode = smsCode;
    }

    public User() {

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(int smsCode) {
        this.smsCode = smsCode;
    }
}

