package com.opencart.Models.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserResponse {

    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
    private String createdAt;

    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getFirst_name() {
        return first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public String getAvatar() {
        return avatar;
    }
    public String getCreatedAt() {
        return createdAt;
    }
}
