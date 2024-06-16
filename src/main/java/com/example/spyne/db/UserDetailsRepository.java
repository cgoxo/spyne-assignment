package com.example.spyne.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetailsEntity, Long> {

    List<UserDetailsEntity> findAll();

    Optional<UserDetailsEntity> findByUserId(String userId);

    List<UserDetailsEntity> findAllByName(String name);
}
