package by.pr.feignthymeleaf.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    private String isbn;
    private String author;
    private String title;
    private String synopsis;
    private String language;
}
