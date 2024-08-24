package com.formation.spring.Shared.Dto;

import java.io.Serializable;

public class UserDto implements Serializable {

    private long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String encrybtPassword;
    private String emailVerificationToken;
    private Boolean emailVerficationStatus;

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    private Boolean admin;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncrybtPassword() {
        return encrybtPassword;
    }

    public void setEncrybtPassword(String encrybtPassword) {
        this.encrybtPassword = encrybtPassword;
    }

    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    public Boolean getEmailVerficationStatus() {
        return emailVerficationStatus;
    }

    public void setEmailVerficationStatus(Boolean emailVerficationStatus) {
        this.emailVerficationStatus = emailVerficationStatus;
    }
}
