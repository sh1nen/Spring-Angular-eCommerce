package com.bookstore.services;

import com.bookstore.domain.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);
    Book findOne(Long id);
    List<Book> findAll();
    List<Book> blurrySearch(String title);
    void removeBook(Long id);
}
