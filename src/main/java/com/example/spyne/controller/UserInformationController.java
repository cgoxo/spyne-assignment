package com.example.spyne.controller;

import com.example.spyne.models.Response;
import com.example.spyne.models.UserDetailsDto;
import com.example.spyne.models.UserRequest;
import com.example.spyne.service.UserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("v1")
@Slf4j
public class UserInformationController {

    private final UserDetailsService userDetailsService;

    public UserInformationController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("insert/user")
    public ResponseEntity<Response<String>> insertUser(@RequestBody UserRequest userRequest) {
        try {
            userDetailsService.insertUser(userRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(new Response<>("success", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>("Failed", null));
        }
    }

    @GetMapping("get-all/users")
    public ResponseEntity<Response<List<UserDetailsDto>>> getAllUsers() {
        try {
            List<UserDetailsDto> userDetailsDtoList = userDetailsService.getUsers();
            return ResponseEntity.status(HttpStatus.OK).body(new Response<>(userDetailsDtoList, null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, null));
        }
    }

    @PutMapping("/update/user/{userId}")
    public ResponseEntity<Response<String>> updateUser(
            @PathVariable String userId,
            @RequestBody UserRequest userRequest) {
        try {
            userDetailsService.updateUser(userId, userRequest);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<>("success", null));
        } catch (Exception e) {
            log.error("Error while updating user", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, null));
        }
    }

    @DeleteMapping("/delete/user/{userId}")
    public ResponseEntity<Response<String>> deleteUser(@PathVariable String userId) {
        try {
            userDetailsService.deleteUser(userId);
            return ResponseEntity.ok().body(new Response<>("success", null));
        } catch (Exception e) {
            log.error("Error while deleting user", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, null));
        }
    }

    @GetMapping("/search/user")
    public ResponseEntity<Response<List<UserDetailsDto>>> searchUserByName(@RequestParam String name) {
        try {
            List<UserDetailsDto> users = userDetailsService.searchUsersByName(name);
            return ResponseEntity.ok().body(new Response<>(users, null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response<>(null, null));
        }
    }


}
