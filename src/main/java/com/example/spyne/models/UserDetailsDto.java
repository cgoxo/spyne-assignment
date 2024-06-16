package com.example.spyne.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDetailsDto {
    private String userId;
    private String name;
    private String mobile;
    private String email;
}
