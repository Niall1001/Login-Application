package com.niallwalters.loginapp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Getter
@Setter
public class UpdateAppUserViewModel {
    @NotEmpty
    @Size(min = 1, max = 255)
    private String name;

    @NotEmpty
    @Size(min = 1, max = 255)
    private String emailAddress;

    private Date dob;

    @Size(min = 1, max = 255)
    private String password;

    private String user_type;
}
