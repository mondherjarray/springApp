package com.formation.spring.Controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.formation.spring.Entities.UserEntity;
import com.formation.spring.Repository.UserRepository;
import com.formation.spring.Request.UserRequest;
import com.formation.spring.Responses.UserResponse;
import com.formation.spring.Services.UserService;
import com.formation.spring.Shared.Dto.UserDto;
import com.formation.spring.Shared.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")  //localhost:8080/users
public class UserController {
    @Autowired
     UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    Utils utils;
    @GetMapping
    public String getUser(){
        return "function get user called";
    }
    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest){

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userRequest, userEntity);

      //  UserEntity checkUser = userRepository.findByEmail(userEntity.getEmail());
        //if(checkUser != null) throw new RuntimeException("User already exists");
      //  UserDto createUser = userService.createUser(userDto);
        userEntity.setUserId(utils.generateStringId(30));
        userEntity.setEncrybtPassword("sdffdsfdfd");
        UserEntity newUser = userRepository.save(userEntity);


        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(userEntity, userResponse);



        return userResponse;
    }
    @PutMapping
    public String updateUser(){
        return "function update user called";
    }
    @DeleteMapping
    public String deleteUser(){
        return "function delete user called";
    }

}
