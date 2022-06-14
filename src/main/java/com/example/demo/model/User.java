package com.example.demo.model;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "users")
public class User extends BaseModel<User> implements UserDetails {
    
    @Id
	private int id;

    @Column(name = "id_ref")
    private String uuid;

    @Column(name = "username")
    private String username;

    @Column(name = "firstname")
    private String firtname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "status")
    private int status;

    @Column(name = "email")
    private String email;

    public String getEmail() {
        return this.email;
    }

    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirtname() {
        return this.firtname;
    }

    public void setFirtname(String firtname) {
        this.firtname = firtname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsername() {
        return this.username;
    }

    public int getId() {
        return this.id;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
	public String toString() {
		return "User [id=" + id + ", uuid=" + uuid + "]";
	}

    @Override
    public User updateWith(User model) {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
		this.password = password;
	}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
