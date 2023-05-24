package com.example.smartContact.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.smartContact.model.contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.smartContact.model.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface contactRepository extends JpaRepository<contact,Integer> {
    @Query(value="SELECT * FROM contact c WHERE c.user_id = :id AND c.name LIKE %:search%",nativeQuery = true)
    public Page<contact> findBySpecificuser(@Param("id") int id, Pageable pageable,@Param("search") String search) ;

    public Page<contact> findByuser(user user,Pageable pageable);
}
