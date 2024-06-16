package com.example.spyne.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {
    String name;
    String mobile;
    String email;
}
