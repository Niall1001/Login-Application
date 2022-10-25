package com.niallwalters.loginapp.controller;

import com.niallwalters.loginapp.configuration.Mapper;
import com.niallwalters.loginapp.dto.CreateAuthenticationDTO;
import com.niallwalters.loginapp.dto.GrabAuthenticationDTO;
import com.niallwalters.loginapp.model.AuthenticationViewModel;
import com.niallwalters.loginapp.model.CreateAuthenticationViewModel;
import com.niallwalters.loginapp.service.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@Tag(name = "Authentication Controller")
public class AuthenticationController {

    private final Mapper mapper;
    private final AuthenticationService authenticationService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AuthenticationViewModel> createAuthenticationToken(@Valid @RequestBody final CreateAuthenticationViewModel createAuthenticationViewModel){
        final CreateAuthenticationDTO createAuthenticationDTO = mapper.map(createAuthenticationViewModel, CreateAuthenticationDTO.class);
        final GrabAuthenticationDTO grabAuthenticationDTO = authenticationService.createAuthenticationToken(createAuthenticationDTO);
        final AuthenticationViewModel authenticationViewModel = mapper.map(grabAuthenticationDTO, AuthenticationViewModel.class);
        return new ResponseEntity<>(authenticationViewModel, HttpStatus.CREATED);
    }
}
