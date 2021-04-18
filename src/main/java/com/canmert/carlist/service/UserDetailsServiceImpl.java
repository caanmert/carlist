package com.canmert.carlist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

import com.canmert.carlist.model.ConfirmationToken;
import com.canmert.carlist.model.User;
import com.canmert.carlist.repository.ConfirmationTokenRepository;
import com.canmert.carlist.repository.UserRepository;

/**
 * UserDetailsService
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    //private final BCryptPasswordEncoder bcryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSenderService emailSenderService;
    
    @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, ConfirmationTokenService confirmationTokenService, EmailSenderService emailSenderService) {
        this.userRepository = userRepository;
        //this.bcryptPasswordEncoder = bcryptPasswordEncoder;
        this.confirmationTokenService = confirmationTokenService;
        this.emailSenderService = emailSenderService;
    }
    

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with:" + email + "not found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority("user")));
    }

    public void signUpUser(User user){
        /*user.setPassword(passwordEncoder().encode(user.getPassword()));
        String password = user.getPassword();
        System.out.println(password);
        final String encryptedPassword = passwordEncoder().encode(user.getPassword());
        user.setPassword(encryptedPassword);*/
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if(!existingUser.isPresent()){
            
        user.setPassword(passwordEncoder().encode(user.getPassword()));
         userRepository.save(user);
         final ConfirmationToken confirmationToken = new ConfirmationToken(user);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        sendConfirmationMail(user.getEmail(), confirmationToken.getConfirmationToken());
        }
    }

    public void confirmUser(ConfirmationToken confirmationToken){
        final User user = confirmationToken.getUser();
        user.setEnabled(true);
        userRepository.save(user);
        confirmationTokenService.deleteConfirmationToken(confirmationToken.getId());
    }

    public void sendConfirmationMail(String userMail, String token) {

        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userMail);
        mailMessage.setSubject("Mail Confirmation Link!");
        mailMessage.setFrom("<MAIL>");
        mailMessage.setText(
                "Thank you for registering. Please click on the below link to activate your account." + "http://localhost:8080/register/confirm?token="
                        + token);
    
        emailSenderService.sendEmail(mailMessage);
    }

}