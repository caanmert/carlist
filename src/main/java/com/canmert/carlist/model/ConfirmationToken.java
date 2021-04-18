package com.canmert.carlist.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ConfirmationToken {
    
  public  ConfirmationToken(){}

  public  ConfirmationToken(User user){
        this.user = user;
        this.createdDate = LocalDate.now();
        this.confirmationToken = UUID.randomUUID().toString();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String confirmationToken;

    private LocalDate createdDate;

    @OneToOne
    @JoinColumn
    private User user;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfirmationToken() {
        return this.confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public LocalDate getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", confirmationToken='" + getConfirmationToken() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }

}