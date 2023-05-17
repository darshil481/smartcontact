package com.example.smartContact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.smartContact.model.contact;
import org.springframework.stereotype.Repository;

@Repository
public interface contactRepository extends JpaRepository<contact,Integer> {
}
