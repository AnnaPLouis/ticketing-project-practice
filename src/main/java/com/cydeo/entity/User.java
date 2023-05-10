package com.cydeo.entity;

import com.cydeo.dto.RoleDTO;
import com.cydeo.enums.Gender;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String userName;
    private String passWord;
    private String confirmPassWord;
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phone;

    @ManyToOne
    private Role role;
}
