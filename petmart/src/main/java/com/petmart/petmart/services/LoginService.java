package com.petmart.petmart.services;


import com.petmart.petmart.dto.UserDTO;
import com.petmart.petmart.entity.Roles;
import com.petmart.petmart.entity.Users;
import com.petmart.petmart.payload.request.SignUpRequest;
import com.petmart.petmart.reposistory.UserReposistory;
import com.petmart.petmart.services.imp.LoginServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
    public class LoginService implements LoginServicesImp {

    @Autowired
    UserReposistory userReposistory;

    @Override
    public List<UserDTO> getAllUser(){

        List<Users> usersList = userReposistory.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for(Users users: usersList){
            UserDTO userDTO = new UserDTO();
            userDTO.setId(users.getId());
            userDTO.setUsername(users.getUsername());
            userDTO.setPassword(users.getPassword());
            userDTO.setCreateDate(users.getCreateDate());

            userDTOList.add(userDTO);
        }

        return userDTOList;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        List<Users> userList = userReposistory.findByUsernameAndPassword(username, password);
        return userList.size()>0;
    }

    @Override
    public boolean addUser(SignUpRequest signUpRequest) {

        Roles roles = new Roles();
        roles.setId(signUpRequest.getRoleId());

        Users users = new Users();
        users.setUsername(signUpRequest.getUsername());
        users.setPassword(signUpRequest.getPassword());
        users.setRoles(roles);
        users.setCreateDate(LocalDateTime.now());
        try {
            userReposistory.save(users);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
