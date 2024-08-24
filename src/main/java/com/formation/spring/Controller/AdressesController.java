package com.formation.spring.Controller;


import com.formation.spring.Request.AdresseRequest;
import com.formation.spring.Responses.AdresseResponse;
import com.formation.spring.Services.AdresseService;
import com.formation.spring.Services.UserService;
import com.formation.spring.Shared.Dto.AdresseDto;
import com.formation.spring.Shared.Dto.UserDto;
import com.formation.spring.Shared.Utils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/adresses")
public class AdressesController {
    @Autowired
    AdresseService adresseService;
    @Autowired
    UserService userService;
    @Autowired
    Utils utils;
    @GetMapping("/{id}")
    public AdresseResponse getAdresse(@PathVariable(name = "id") String adresseId){
        AdresseDto adresseDto = adresseService.getAdresse(adresseId);
        AdresseResponse adresseResponse = new AdresseResponse();

        BeanUtils.copyProperties(adresseDto, adresseResponse);

      return adresseResponse;
    }
    @GetMapping
    public List<AdresseDto> getAdresse(Principal principal){
        String currentUserEmail =  principal.getName();
        UserDto userLogin = userService.getUser(currentUserEmail);
        List<AdresseDto> adresseDto = adresseService.getAdressesByUserId(userLogin.getUserId());

        Type listType = new TypeToken<List<AdresseDto>>(){}.getType();
        List<AdresseResponse> adresseResponse = new ModelMapper().map(adresseDto, listType);


        return  adresseDto;
    }

    @PostMapping
    public AdresseResponse createAdresse(@RequestBody AdresseRequest adresseRequest, Principal principal){

        AdresseDto adresseDto  = new AdresseDto();
        BeanUtils.copyProperties(adresseRequest, adresseDto);


        adresseDto.setAdresseId(utils.generateStringId(30));
        String currentUserEmail =  principal.getName();
        UserDto userLogin = userService.getUser(currentUserEmail);

        adresseDto.setUser_id(userLogin.getUserId());

        AdresseDto createAdresse = adresseService.createAdresse(adresseDto);

        AdresseResponse adresseResponse = new AdresseResponse();
        BeanUtils.copyProperties(createAdresse, adresseResponse);

        return adresseResponse;
    }
    @PutMapping(path = "/{id}")
    public AdresseResponse UpdateAdresse(@PathVariable String id,@RequestBody AdresseRequest adresseRequest){

        AdresseDto adresseDto  = new AdresseDto();
        BeanUtils.copyProperties(adresseRequest, adresseDto);

        AdresseDto updateAdresse = adresseService.updateAdresse(id, adresseDto);

        AdresseResponse adresseResponse = new AdresseResponse();
        BeanUtils.copyProperties(updateAdresse, adresseResponse);

        return adresseResponse;
    }

    @DeleteMapping(path = "/{id}")
    public Object deleteAdresse(@PathVariable String id){

        adresseService.deleteAdresse(id);
        return HttpStatus.NO_CONTENT;
    }

}
