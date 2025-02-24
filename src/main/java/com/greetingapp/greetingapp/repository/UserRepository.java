package com.greetingapp.greetingapp.repository;

import com.greetingapp.greetingapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface for database operations on UserEntity
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}