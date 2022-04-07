package com.example.charan;

public interface studentRepository {package net.codejava;
import org.springframework.data.jpa.repository.JpaRepository;
    public interface ProductRepository extends JpaRepository<student, Long> {
    }
}
