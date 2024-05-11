package com.book.entity;

import lombok.Data;

@Data
public class Books {
    int bid;
    String name;
    String author;
    String publisher;
    int pubYear;
}
