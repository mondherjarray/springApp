package com.formation.spring.Services;

import com.formation.spring.Shared.Dto.AdresseDto;

import java.util.List;

public interface AdresseService {

   List<AdresseDto> getAll();
    AdresseDto createAdresse(AdresseDto adresseDto);


    AdresseDto getAdresse(String adresseId);
    List<AdresseDto> getAdressesByUserId(String id);

    AdresseDto updateAdresse(String id, AdresseDto adresseDto);

    void deleteAdresse(String id);
}
