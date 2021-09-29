package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Bookshelf;
import com.example.demo.repository.BookshelfRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookshelfService {

    private final BookshelfRepository bookshelfRepository;

    public List<Bookshelf> getAllBookshelfList() {
        return bookshelfRepository.findAll();
    }

    public Bookshelf getOneById(Long bookshelfId) {
        Optional<Bookshelf> byId = bookshelfRepository.findById(bookshelfId);

        return byId.orElseGet(Bookshelf::new);
    }
}
