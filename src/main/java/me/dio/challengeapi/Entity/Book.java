package me.dio.challengeapi.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Entity
@Table(name="tb_Book")
public class Book {



    @ManyToMany()
    @JoinTable(name = "books_author", joinColumns = @JoinColumn(name = "id_book"),
            inverseJoinColumns = @JoinColumn(name = "id_author"))
    private Set<Author> authors = new HashSet<>();



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_book", nullable = false, unique = true)
    private Integer id_book;


    @Column(name="book_name", nullable = false, unique = true)
    private String book_name;


    @Column(name="book_category", nullable = false, unique = true)
    private String book_category;

    @Column(name="book_description", nullable = false, unique = true)
    private String book_description;

    @Column(name="book_pages", nullable = false, unique = true)
    private Integer pages;


    public Book(Integer id_book, String book_name, String book_category, String book_description, Integer pages) {
        this.id_book = id_book;
        this.book_name = book_name;
        this.book_category = book_category;
        this.book_description = book_description;
        this.pages = pages;
    }

    public Book (){

    }

    @Override
    public String toString() {
        return "Book{" +
                "id_book=" + id_book +
                ", book_name='" + book_name + '\'' +
                ", book_category='" + book_category + '\'' +
                ", book_description='" + book_description + '\'' +
                ", pages=" + pages +
                '}';
    }
}
