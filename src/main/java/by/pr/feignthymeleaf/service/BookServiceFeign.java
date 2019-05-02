package by.pr.feignthymeleaf.service;

import by.pr.feignthymeleaf.client.BookClient;
import by.pr.feignthymeleaf.model.Book;
import by.pr.feignthymeleaf.model.BookResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceFeign implements BookService {

    private BookClient bookClient;

    @Autowired
    public BookServiceFeign(BookClient bookClient) {
        this.bookClient = bookClient;
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookClient.findByIsbn(isbn).getBook();
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = bookClient.findAll()
                .stream()
                .map(BookResource::getBook)
                .collect(Collectors.toList());
        return books;
    }

    @Override
    public void create(Book book) {
    }
}
