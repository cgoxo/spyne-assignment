package com.example.spyne.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DiscussionRequest {
    String discussion;
    byte[] image;
    String hashTag;
}
