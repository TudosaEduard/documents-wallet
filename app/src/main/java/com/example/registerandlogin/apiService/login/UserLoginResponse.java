package com.example.registerandlogin.apiService.login;

import java.io.Serializable;

public class UserLoginResponse implements Serializable {
    private Long id;
    private String firstName;

    public UserLoginResponse(Long id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "UserLoginResponse{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
