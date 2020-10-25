package com.albanianyachting.dto;

import com.albanianyachting.sql.Role;

import java.io.Serializable;
import java.util.List;

public class UsersDTO implements Serializable {
    private Long id;
   // private String name;
   // private String lastname;
    private String email;
    private String username;
    private String password;
    private List<Role> role;

    public UsersDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
