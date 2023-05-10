package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import com.cydeo.service.UserService;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;

        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> listAllUsers() {

        List<User> userList = userRepository.findAllByIsDeleted(false);
        return userList.stream().map(userMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {

        User user = userRepository.findByUserNameAndIsDeleted(username, false);

        return userMapper.convertToDTO(user);

    }

    @Override
    public void save(UserDTO userDTO) {

        userRepository.save(userMapper.convertToEntity(userDTO));

    }

    @Override
    public UserDTO update(UserDTO user) {

        //Find current user
        User user1 = userRepository.findByUserNameAndIsDeleted(user.getUserName(), false);
        //map update user dto to entity
        User convertedUser = userMapper.convertToEntity(user);
        //set id to the converted object
        convertedUser.setId(user1.getId());
        //save the updated user in db
        userRepository.save(convertedUser);

        return findByUserName(user.getUserName());



    }

    @Override
    public void delete(String username) {

        User user = userRepository.findByUserNameAndIsDeleted(username, false);
        user.setIsDeleted(true);
        user.setUserName(user.getUserName()+"-"+user.getId());
        userRepository.save(user);




    }

    @Override
    public List<UserDTO> listAllByRole(String description) {

        List<User> userList = userRepository.findByRoleDescriptionIgnoreCaseAndIsDeleted(description, false);

        return userList.stream().map(userMapper::convertToDTO).collect(Collectors.toList());
    }
}
