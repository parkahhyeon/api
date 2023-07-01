package com.hakg.api.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.util.StringUtils;

@Data
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public class Member {

    private long mem_seq;
    private String mem_id;
    private String mem_pwd;
    private String mem_pwd_salt;
    private String mem_name;
    private String mem_gender;
    private String mem_reg_date;
    private String mem_last_login;
    private String mem_status;

    @Builder
    public Member(long mem_seq, String mem_id, String mem_pwd, String mem_pwd_salt,
                  String mem_name, String mem_gender, String mem_reg_date,
                  String mem_last_login, String mem_status ) {
        this.mem_seq = mem_seq;
        this.mem_id = mem_id;
        this.mem_pwd = mem_pwd;
        this.mem_pwd_salt = mem_pwd_salt;
        this.mem_name = mem_name;
        this.mem_gender = mem_gender;
        this.mem_reg_date = mem_reg_date;
        this.mem_last_login = mem_last_login;
        this.mem_status = mem_status;
    }

    public void encodingPassword(PasswordEncoder passwordEncoder) {
        if (StringUtils.isEmpty(mem_pwd)) {
            return;
        }
        mem_pwd = passwordEncoder.encode(mem_pwd);
    }

    public void clearPassword() {
        this.mem_pwd = "";
    }
}