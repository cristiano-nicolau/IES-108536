package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.*;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByTitle(String title);
}