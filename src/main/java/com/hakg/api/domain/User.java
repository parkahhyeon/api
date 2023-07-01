package com.hakg.api.domain;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String email;
    private String pwd;

}