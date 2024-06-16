package com.example.spyne.db;

import com.example.spyne.models.UserDetailsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserDetailsDbService {

    private final UserDetailsRepository userDetailsRepository;

    public UserDetailsDbService(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    public void saveUser(UserDetailsEntity userDetailsEntity) {
        userDetailsRepository.save(userDetailsEntity);
    }

    public void deleteUser(UserDetailsEntity userDetailsEntity) {
        userDetailsRepository.delete(userDetailsEntity);
    }

    public List<UserDetailsDto> getUsers() {
        List<UserDetailsEntity> userDetailsEntities = userDetailsRepository.findAll();
        List<UserDetailsDto> userDetailsDtos = new ArrayList<>();
        for (UserDetailsEntity userDetailsEntity : userDetailsEntities) {
            userDetailsDtos.add(new UserDetailsDto(userDetailsEntity.getUserId(), userDetailsEntity.getName(), userDetailsEntity.getMobile(), userDetailsEntity.getEmailId()));
        }
        return userDetailsDtos;
    }

    public UserDetailsEntity findByUserId(String userId) {
        Optional<UserDetailsEntity> userDetailsEntity = userDetailsRepository.findByUserId(userId);
        if(userDetailsEntity.isEmpty()) {
            log.error("User with id {} not found", userId);
            throw new IllegalArgumentException("User not found with userId: " + userId);
        }
        return userDetailsEntity.get();
    }

    public List<UserDetailsDto> findAllByName(String name) {
        List<UserDetailsEntity> userDetailsEntities = userDetailsRepository.findAllByName(name);
        if(userDetailsEntities.isEmpty()) {
            return null;
        }
        List<UserDetailsDto> userDetailsDtos = new ArrayList<>();
        for (UserDetailsEntity userDetailsEntity : userDetailsEntities) {
            userDetailsDtos.add(new UserDetailsDto(userDetailsEntity.getUserId(),
                                userDetailsEntity.getName(),
                                userDetailsEntity.getMobile(),
                                userDetailsEntity.getEmailId()));
        }
        return userDetailsDtos;
    }
}
