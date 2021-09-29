package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Bookshelf;

public interface BookshelfRepository extends JpaRepository<Bookshelf, Long> {
}
