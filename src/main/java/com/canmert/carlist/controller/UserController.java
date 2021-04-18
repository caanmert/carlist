package com.canmert.carlist.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.canmert.carlist.model.ConfirmationToken;
import com.canmert.carlist.model.User;
import com.canmert.carlist.service.ConfirmationTokenService;
import com.canmert.carlist.service.UserDetailsServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final ConfirmationTokenService confirmationTokenService;

    public UserController(UserDetailsServiceImpl userDetailsServiceImpl, ConfirmationTokenService confirmationTokenService) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.confirmationTokenService = confirmationTokenService;
    }   

    @GetMapping(value = "/login")
   public String signIn(){
        return "sign-in";
    }

    @PostMapping(value ="/register")
   public void signUp(@Valid @RequestBody User user){
       System.out.println(user.getPassword());
       userDetailsServiceImpl.signUpUser(user);
        
    }

    @GetMapping("/register/confirm")
    public  String confirmMail(@RequestParam("token")String token){ 
        Optional<ConfirmationToken>optionalConfirmationToken = confirmationTokenService.findConfirmationTokenByToken(token);
        optionalConfirmationToken.ifPresent(userDetailsServiceImpl::confirmUser);

		return "redirect:/login";
    }
    

    
}