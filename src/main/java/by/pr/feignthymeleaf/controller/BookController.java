package by.pr.feignthymeleaf.controller;

import by.pr.feignthymeleaf.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping({"", "/", "books", "books.html"})
    public String getBooksPage(Model model) {
        model.addAttribute("books", bookService.findAll());
        log.info("main page processed");
        return "books";
    }

    @RequestMapping("book/{isbn}")
    public String showByIsbn(@PathVariable String isbn, Model model) {
        model.addAttribute("book", bookService.findByIsbn(isbn));
        log.info("processed book details page");
        return "book/show";
    }

}
