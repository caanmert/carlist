package com.canmert.carlist.model;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity(name = "users")
public class User implements UserDetails {

    public User() {}


    public User(String username, String email, String password,Boolean enabled) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    
    @Column(nullable = false, unique = true)
    private String username;

    @Email
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String password;

    private UserRole userRole = UserRole.USER;

    private Boolean locked = false;

    private Boolean enabled = false;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        
        final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(simpleGrantedAuthority);
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return this.userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }


    public Boolean isLocked() {
        return this.locked;
    }

    public Boolean getLocked() {
        return this.locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }



    @Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
    }
    

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" ;
    }


}


