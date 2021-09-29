package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class BookDto {

    private String title;
    private String author;
    private Long bookshelfId;

}
