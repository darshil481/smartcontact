package com.example.smartContact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.smartContact.model.user;

public interface userRepository extends JpaRepository<user,Integer> {
}
