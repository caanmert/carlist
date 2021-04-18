package com.canmert.carlist.repository;

import java.util.Optional;

import com.canmert.carlist.model.ConfirmationToken;

import org.springframework.data.repository.CrudRepository;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken,Long> {
    Optional<ConfirmationToken> findConfirmationTokenByConfirmationToken(String token);
}