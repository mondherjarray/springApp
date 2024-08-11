package com.formation.spring.Controller;

import com.formation.spring.Entities.UserEntity;
import com.formation.spring.Repository.UserRepository;
import com.formation.spring.Request.UserRequest;
import com.formation.spring.Responses.UserResponse;
import com.formation.spring.Services.UserService;
import com.formation.spring.Shared.Dto.UserDto;
import com.formation.spring.Shared.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    Utils utils;
    @GetMapping(path="/{id}")
    public UserResponse getUser(@PathVariable String id){
        UserDto userDto = userService.getUserByUserId(id);

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(userDto, userResponse);

        return userResponse ;
    }
    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest){

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest, userDto);

        UserEntity checkUser = userRepository.findByEmail(userDto.getEmail());
        if(checkUser != null) throw new RuntimeException("User already exists");

        userDto.setUserId(utils.generateStringId(30));
        userDto.setEncrybtPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
        UserDto createUser = userService.createUser(userDto);

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(createUser, userResponse);

        return userResponse;
    }
    @PutMapping(path = "/{id}")
    public UserResponse updateUser(@PathVariable String id, @RequestBody UserRequest userRequest){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest, userDto);

        UserDto updateUser = userService.updateUser(id, userDto);

        UserResponse userResponse = new UserResponse();

        BeanUtils.copyProperties(updateUser, userResponse);
        return userResponse;
    }
    @DeleteMapping(path = "/{id}")
    public Object deleteUser(@PathVariable String id){

        userService.deleteUser(id);
        return HttpStatus.NO_CONTENT;
    }

}
