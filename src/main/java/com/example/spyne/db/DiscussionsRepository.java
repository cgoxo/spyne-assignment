package com.example.spyne.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiscussionsRepository extends JpaRepository<DiscussionsEntity, Long> {
    Optional<DiscussionsEntity> findByDiscussionId(String discussionId);
}
