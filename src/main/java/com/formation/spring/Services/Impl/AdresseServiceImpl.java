package com.formation.spring.Services.Impl;

import com.formation.spring.Entities.AdresseEntity;
import com.formation.spring.Entities.UserEntity;
import com.formation.spring.Repository.AdresseRepository;
import com.formation.spring.Repository.UserRepository;
import com.formation.spring.Services.AdresseService;
import com.formation.spring.Shared.Dto.AdresseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
@Service
public class AdresseServiceImpl implements AdresseService {
    @Autowired
    AdresseRepository adresseRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public List<AdresseDto> getAll() {
        return null;
    }

    @Override
    public AdresseDto createAdresse(AdresseDto adresseDto) {
        AdresseEntity adresseEntity = new AdresseEntity();

        BeanUtils.copyProperties(adresseDto, adresseEntity);
        AdresseEntity createAdresse =adresseRepository.save(adresseEntity);

        AdresseDto adresse = new AdresseDto();
        BeanUtils.copyProperties(createAdresse, adresse);

        return adresse;
    }

    @Override
    public AdresseDto getAdresse(String adresseId) {
        AdresseEntity adresseEntity = adresseRepository.findByAdresseId(adresseId);


        AdresseDto adresseDto  = new AdresseDto();

        BeanUtils.copyProperties(adresseEntity, adresseDto);

        return adresseDto;
    }

    @Override
    public List<AdresseDto> getAdressesByUserId(String id) {


        UserEntity currentUser = userRepository.findByUserId(id);


        List<AdresseEntity> adresseEntities = currentUser.getAdmin() == true ? (List<AdresseEntity>) adresseRepository.findAll() : adresseRepository.findByUserId(id);

        Type listType = new TypeToken<List<AdresseDto>>(){}.getType();
        List<AdresseDto> adresseDto = new ModelMapper().map(adresseEntities, listType);


        return adresseDto;
    }

    @Override
    public AdresseDto updateAdresse(String id, AdresseDto adresseDto) {
        AdresseEntity adresseEntity = adresseRepository.findByAdresseId(id);
        adresseEntity.setCity(adresseDto.getCity());
        adresseEntity.setCountry(adresseDto.getCountry());
        adresseEntity.setPostal(adresseDto.getPostal());
        adresseEntity.setStreet(adresseDto.getStreet());


        AdresseEntity adresseUpdate = adresseRepository.save(adresseEntity);

        AdresseDto adresse = new AdresseDto();
        BeanUtils.copyProperties(adresseUpdate, adresse);

        return adresse;
    }

    @Override
    public void deleteAdresse(String id) {
        AdresseEntity adresseEntity = adresseRepository.findByAdresseId(id);

        adresseRepository.delete(adresseEntity);
    }


}
