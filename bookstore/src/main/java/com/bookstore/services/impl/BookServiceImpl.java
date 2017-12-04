package com.bookstore.services.impl;

import com.bookstore.domain.Book;
import com.bookstore.repositories.BookRepository;
import com.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findOne(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public List<Book> findAll() {
        List<Book> result = new ArrayList<>();
        bookRepository.findAll().forEach(result::add);
        List<Book> activeBooks = new ArrayList<>();
        result.stream()
              .filter(Book::isActive)
              .forEach(activeBooks::add);
        return activeBooks;
    }

    @Override
    public List<Book> blurrySearch(String keyword) {
        List<Book> bookList = bookRepository.findByTitleContaining(keyword);
        List<Book> activeBooks = new ArrayList<>();
        bookList.stream()
              .filter(Book::isActive)
              .forEach(activeBooks::add);
        return activeBooks;
    }

    @Override
    public void removeBook(Long id) {
        bookRepository.delete(id);
    }
}
