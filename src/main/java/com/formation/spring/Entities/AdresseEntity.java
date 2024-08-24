package com.formation.spring.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="adresses")
public class AdresseEntity implements Serializable {

    @Id
    @GeneratedValue
     private long id;
    @Column(nullable = false, length = 255)
    private String adresseId;
    @Column(nullable = false, length = 255)
    private String city;
    @Column(nullable = false, length = 255)
    private String country;
    @Column(nullable = false, length = 255)
    private String postal;
    @Column(nullable = false, length = 255)
    private String street;

    @Column(nullable = false, length = 255)
    private String userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdresseId() {
        return adresseId;
    }

    public void setAdresseId(String adresseId) {
        this.adresseId = adresseId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getUser_id() {
        return userId;
    }

    public void setUser_id(String userId) {
        this.userId = userId;
    }
}
