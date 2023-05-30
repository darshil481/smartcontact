package com.example.smartContact.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.smartContact.model.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.smartContact.model.User;

@Repository
public interface contactRepository extends JpaRepository<Contact,Integer> {
    @Query(value="SELECT * FROM contact c WHERE c.user_id = :id AND c.name LIKE %:search%",nativeQuery = true)
    public Page<Contact> findBySpecificuser(@Param("id") int id, Pageable pageable, @Param("search") String search) ;

    public Page<Contact> findByuser(User user, Pageable pageable);
}
