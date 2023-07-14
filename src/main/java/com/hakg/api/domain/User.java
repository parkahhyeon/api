package com.hakg.api.domain;

import lombok.Data;

@Data   // Getter Setter
public class User {

    private String userId;
    private String email;
    private String pwd;

}