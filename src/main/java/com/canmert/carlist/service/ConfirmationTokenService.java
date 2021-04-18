package com.canmert.carlist.service;

import java.util.Optional;

import com.canmert.carlist.model.ConfirmationToken;
import com.canmert.carlist.repository.ConfirmationTokenRepository;

import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenService {
    
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public ConfirmationTokenService(ConfirmationTokenRepository confirmationTokenRepository){
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    public void saveConfirmationToken(ConfirmationToken confirmationToken){
        confirmationTokenRepository.save(confirmationToken);
    }

    public void deleteConfirmationToken(Long id){
        confirmationTokenRepository.deleteById(id);
    }

    public Optional<ConfirmationToken> findConfirmationTokenByToken(String token) {
		return confirmationTokenRepository.findConfirmationTokenByConfirmationToken(token);
	}
}