package com.example.Library.repository;

import com.example.Library.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    boolean existsByFullname(String fullname);
    Users findByUsername(String username);
}
