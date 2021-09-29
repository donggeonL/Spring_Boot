package com.example.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Bookshelf {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int floor;

    @OneToMany(mappedBy = "bookshelf")
    private final List<Book> books = new ArrayList<>();



    public void addBook(Book book) {
        books.add(book);
        book.setBookshelf(this);
    }

    @Builder
    public Bookshelf(String name, int floor) {
        this.name = name;
        this.floor = floor;
    }
}
