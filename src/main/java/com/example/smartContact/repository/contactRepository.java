package com.example.smartContact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.smartContact.model.contact;
import org.springframework.stereotype.Repository;
import com.example.smartContact.model.user;

import java.util.List;
import java.util.Optional;

@Repository
public interface contactRepository extends JpaRepository<contact,Integer> {
    public List<contact> findByUser(Optional<user> user);
}
