package by.pr.feignthymeleaf.service;

import by.pr.feignthymeleaf.model.Book;

import java.util.List;

public interface BookService {

    public Book findByIsbn(String isbn);

    List<Book> findAll();

    void create(Book book);

}
