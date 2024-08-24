package com.formation.spring.Responses;

public class AdresseResponse {
    private String adresseId;
    private String city;
    private String country;
    private String postal;
    private String street;

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
