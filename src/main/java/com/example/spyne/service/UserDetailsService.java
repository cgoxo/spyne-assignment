package com.example.spyne.service;

import com.example.spyne.db.UserDetailsDbService;
import com.example.spyne.db.UserDetailsEntity;
import com.example.spyne.models.UserDetailsDto;
import com.example.spyne.models.UserRequest;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserDetailsService {

    private final UserDetailsDbService userDetailsDbService;

    public UserDetailsService(UserDetailsDbService userDetailsDbService) {
        this.userDetailsDbService = userDetailsDbService;
    }


    public void insertUser(UserRequest userRequest) {
        UserDetailsEntity userDetailsEntity = new UserDetailsEntity();
        userDetailsEntity.setName(userRequest.getName());
        userDetailsEntity.setMobile(userRequest.getMobile());
        userDetailsEntity.setEmailId(userRequest.getEmail());
        userDetailsEntity.setUserId(UUID.randomUUID().toString());
        userDetailsDbService.saveUser(userDetailsEntity);
    }

    public List<UserDetailsDto> getUsers() {
        return userDetailsDbService.getUsers();
    }

    @Transactional
    public void updateUser(String userId, UserRequest userRequest) {
        UserDetailsEntity userDetailsEntity = userDetailsDbService.findByUserId(userId);
        // Update fields from userRequest to userDetailsEntity
        if (userDetailsEntity == null) {
            return;
        }
        log.info("User Found : {}", userId);
        userDetailsEntity.setName(userRequest.getName());
        userDetailsEntity.setMobile(userRequest.getMobile());
        userDetailsEntity.setEmailId(userRequest.getEmail());
        userDetailsDbService.saveUser(userDetailsEntity);
    }

    @Transactional
    public void deleteUser(String userId) {
        UserDetailsEntity userDetailsEntity = userDetailsDbService.findByUserId(userId);
        // Update fields from userRequest to userDetailsEntity
        if (userDetailsEntity == null) {
            return;
        }
        userDetailsDbService.deleteUser(userDetailsEntity);
    }

    public List<UserDetailsDto> searchUsersByName(String name) {
        return userDetailsDbService.findAllByName(name);
    }
}
