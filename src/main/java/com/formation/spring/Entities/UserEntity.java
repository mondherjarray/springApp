package com.formation.spring.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="users")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String userId;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false, length = 255)
    private String encrybtPassword;
    @Column(nullable = true)
    private String emailVerificationToken;
    @Column(nullable = false )
    private Boolean admin =false;

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    private Boolean emailVerficationStatus = false;

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


}
