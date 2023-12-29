package com.example.Library.repository;

import com.example.Library.model.EmailNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailNewsRepository extends JpaRepository<EmailNews, Long> {
}
