package com.oliveira.willy.bookstore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class BookDTO {

    private Integer id;
    private String name;
    private String description;
    private String author;
    private String genre;
}
