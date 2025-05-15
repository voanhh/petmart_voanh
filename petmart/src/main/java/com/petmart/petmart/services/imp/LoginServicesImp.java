package com.petmart.petmart.services.imp;

import com.petmart.petmart.dto.UserDTO;
import com.petmart.petmart.payload.request.SignUpRequest;

import java.util.List;

public interface LoginServicesImp {
    List<UserDTO> getAllUser();
    boolean checkLogin(String username, String password);
    boolean addUser(SignUpRequest signUpRequest);
}
