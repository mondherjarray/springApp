package com.formation.spring.Services;

import com.formation.spring.Shared.Dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDto);


    UserDto getUser(String email);
    UserDto getUserByUserId(String id);

    UserDto updateUser(String id, UserDto userDto);

    void deleteUser(String id);

}
