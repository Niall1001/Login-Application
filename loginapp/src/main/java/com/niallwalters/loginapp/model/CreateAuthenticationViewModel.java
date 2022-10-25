package com.niallwalters.loginapp.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CreateAuthenticationViewModel {

    @NotEmpty
    private String emailAddress;

    @NotEmpty
    private String password;
}
