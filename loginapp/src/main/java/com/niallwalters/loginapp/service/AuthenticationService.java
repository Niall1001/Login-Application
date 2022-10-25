package com.niallwalters.loginapp.service;

import com.niallwalters.loginapp.dto.CreateAuthenticationDTO;
import com.niallwalters.loginapp.dto.GrabAuthenticationDTO;
import com.niallwalters.loginapp.security.UserSecurityService;
import com.niallwalters.loginapp.util.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserSecurityService userSecurityService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;

    public GrabAuthenticationDTO createAuthenticationToken(final CreateAuthenticationDTO createAuthenticationDTO){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                createAuthenticationDTO.getEmailAddress(), createAuthenticationDTO.getPassword()));
        final UserDetails userDetails = userSecurityService.loadUserByUsername(createAuthenticationDTO.getEmailAddress());
        final String jwt = jwtTokenService.generateToken(userDetails);
        final GrabAuthenticationDTO grabAuthenticationDTO = new GrabAuthenticationDTO();
        grabAuthenticationDTO.setJwt(jwt);
        return grabAuthenticationDTO;
    }

}
