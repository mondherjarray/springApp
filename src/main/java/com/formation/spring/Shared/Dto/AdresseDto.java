package com.formation.spring.Shared.Dto;

import java.io.Serializable;

public class AdresseDto implements Serializable {
    private long id;

    private String adresseId;
    private String city;
    private String country;
    private String postal;
    private String street;
    private String userId;

    public String getUser_id() {
        return userId;
    }

    public void setUser_id(String userId) {
        this.userId = userId;
    }

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
}
