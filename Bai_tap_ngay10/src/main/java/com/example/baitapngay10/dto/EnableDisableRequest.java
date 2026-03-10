package com.example.baitapngay10.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EnableDisableRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String username;

    public EnableDisableRequest() {
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
}
