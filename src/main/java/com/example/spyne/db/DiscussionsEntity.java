package com.example.spyne.db;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "discussion")
@Data
public class DiscussionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discussion_seq")
    @SequenceGenerator(name = "discussion_seq", sequenceName = "discussion_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "discussion_id", unique = true, nullable = false, length = 50)
    private String discussionId;

    @Column(name = "discussion", nullable = false, columnDefinition = "TEXT")
    private String discussion;

    @Column(name = "image", nullable = true)
    private byte[] image;

    @Column(name = "user_id", nullable = false, length = 50)
    private String userId;

    @Column(name = "hash_tag", nullable = false, length = 50)
    private String hashTag;

    @Column(name = "number_of_likes", nullable = false)
    private int numberOfLikes = 0;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
