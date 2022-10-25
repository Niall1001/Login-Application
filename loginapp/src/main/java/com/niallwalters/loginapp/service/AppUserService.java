package com.niallwalters.loginapp.service;

import com.niallwalters.loginapp.configuration.Mapper;
import com.niallwalters.loginapp.dto.AppUserDTO;
import com.niallwalters.loginapp.dto.CreateAppUserDTO;
import com.niallwalters.loginapp.entity.AppUser;
import com.niallwalters.loginapp.exception.ResourceNotFoundException;
import com.niallwalters.loginapp.model.UpdateAppUserViewModel;
import com.niallwalters.loginapp.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserService {
    private final AppUserRepository appUserRepository;
    private final Mapper mapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<AppUserDTO> getAllAppUsers(){
        final List<AppUser> appUserList = appUserRepository.findAll();
        final List<AppUserDTO> appUserDTOList = mapper.map(appUserList, AppUserDTO.class);
        return appUserDTOList;
    }

    public AppUserDTO getAppUserByID(final int id){
        final AppUser appUser = appUserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("App User Cannot be found, ensure the ID is valid."));
        final AppUserDTO appUserDTO = mapper.map(appUser, AppUserDTO.class);
        return appUserDTO;
    }

    public AppUserDTO createAppUser(final CreateAppUserDTO createAppUserDTO){
        final AppUser appUser = mapper.map(createAppUserDTO, AppUser.class);
        appUser.setPassword(bCryptPasswordEncoder.encode(createAppUserDTO.getPassword()));
        appUserRepository.save(appUser);
        return mapper.map(appUser, AppUserDTO.class);
    }

    public AppUserDTO updateAppUser(final int id, final UpdateAppUserViewModel updateAppUserViewModel){
        final AppUser appUser = appUserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("App user cannot be found, ensure the user exists before updating."));
        mapper.map(updateAppUserViewModel, appUser);
        if(updateAppUserViewModel.getPassword() != null){
            appUser.setPassword(bCryptPasswordEncoder.encode(updateAppUserViewModel.getPassword()));
        }
        appUserRepository.save(appUser);
        return mapper.map(appUser, AppUserDTO.class);
    }

    public void deleteAppUser(final int id){
        appUserRepository.deleteById(id);}
}
