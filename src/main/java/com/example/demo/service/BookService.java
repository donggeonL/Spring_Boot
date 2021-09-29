package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.BookDto;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookshelfService bookshelfService;

    public List<Book> getAllBookList() {
        return bookRepository.findAll();
    }

    public void createBook(BookDto bookDto) {
        Book book = Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .build();

        bookshelfService.getOneById(bookDto.getBookshelfId()).addBook(book);

        bookRepository.save(book);
    }

    public Book getOneById(Long id) {
        return bookRepository.findById(id).orElseGet(Book::new);
    }

}
