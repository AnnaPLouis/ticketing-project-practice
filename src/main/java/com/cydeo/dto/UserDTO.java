package com.cydeo.dto;

import com.cydeo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private String confirmPassWord;
    private Gender gender;
    private String phone;
    private boolean enabled;
    private RoleDTO role;


    }

