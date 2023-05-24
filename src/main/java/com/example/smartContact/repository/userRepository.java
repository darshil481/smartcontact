package com.example.smartContact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.smartContact.model.user;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<user,Integer> {

    user findByEmail(String email);
}
