package com.niallwalters.loginapp.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateAppUserDTO {
    private String name;
    private String emailAddress;
    private Date dob;
    private String password;
    private String user_type;
}
