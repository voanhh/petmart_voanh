package com.petmart.petmart.controller;

import com.petmart.petmart.payload.ResponData;
import com.petmart.petmart.payload.request.SignUpRequest;
import com.petmart.petmart.services.LoginService;
import com.petmart.petmart.services.imp.LoginServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginServicesImp loginServicesImp;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username, @RequestParam String password){
        ResponData responData = new ResponData();
        if(loginServicesImp.checkLogin(username, password)){
            responData.setData(true);
            responData.setDesc("Login Successful!");
        }else{
            responData.setData(false);
            responData.setDesc("Failed! Try Again!");
        }

        return new ResponseEntity<>(responData, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest){
        ResponData responData = new ResponData();
        responData.setData(loginServicesImp.addUser(signUpRequest));

        return new ResponseEntity<>(responData, HttpStatus.OK);
    }
}
