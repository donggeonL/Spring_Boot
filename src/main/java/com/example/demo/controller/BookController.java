package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.BookDto;
import com.example.demo.model.Book;
import com.example.demo.model.Bookshelf;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import com.example.demo.service.BookshelfService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BookController {

    private final BookRepository bookRepository;
    private final BookService bookService;
    private final BookshelfService bookshelfService;

    @GetMapping("/book")
    public String getBookList(Model model) {
        List<Book> books = bookService.getAllBookList();

        model.addAttribute("bookList", books);

        return "book-list";
    }

    @GetMapping("/book/add")
    public String getBookAdd(Model model) {
        List<Bookshelf> bookshelves = bookshelfService.getAllBookshelfList();

        model.addAttribute("bookshelfList", bookshelves);

        return "book-add";
    }

    @PostMapping("/book/add")
    public String postBookAdd(BookDto bookDto) {
        System.out.println(bookDto);

        bookService.createBook(bookDto);

        return "redirect:/book";
    }

    @GetMapping("/book/info/{id}")
    public String getBookInfo(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getOneById(id);

        model.addAttribute("book", book);

        return "book-info";
    }

    @GetMapping("/book/update/{id}")
    public String getBookUpdate(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getOneById(id);
        List<Bookshelf> bookshelves = bookshelfService.getAllBookshelfList();

        model.addAttribute("book", book);
        model.addAttribute("bookshelfList", bookshelves);


        return "book-update";
    }

    @PostMapping("/book/update/{id}")
    public String postBookUpdate(@PathVariable("id") Long id, BookDto bookDto) {
        Book book = bookService.getOneById(id);

        book.updateBook(bookDto);
        bookshelfService.getOneById(bookDto.getBookshelfId()).addBook(book);

        bookRepository.save(book);

        return "redirect:/book";
    }

    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        Book book = bookService.getOneById(id);

        bookRepository.delete(book);

        return "redirect:/book";
    }

}
