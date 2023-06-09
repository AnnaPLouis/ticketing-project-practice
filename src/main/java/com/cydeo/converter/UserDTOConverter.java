package com.cydeo.converter;

import com.cydeo.service.UserService;
import org.springframework.core.convert.converter.Converter;
import com.cydeo.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter implements Converter<String, UserDTO> {

    private final UserService userService;

    public UserDTOConverter(UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDTO convert(String source) {
        if(source == null || source.equals("")){
            return null;
        }

        return userService.findByUserName(source);

    }
}
