package me.dio.challengeapi.Entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter

@Entity
@Table(name="tb_Author")
public class Author {


    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Book> bookCollection = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_author", nullable = false, unique = true)
    private Integer id_author;

    @Column(name="author_name", nullable = false, unique = true)
    private String author_name;


    @Column(name="author_age", nullable = false, unique = true)
    private Integer author_age;

    public Author(Integer id_author, String author_name, Integer author_age) {
        this.id_author = id_author;
        this.author_name = author_name;
        this.author_age = author_age;
    }

    public Author(){

    }

    @Override
    public String toString() {
        return "Author{" +
                "id_author=" + id_author +
                ", author_name='" + author_name + '\'' +
                ", author_age=" + author_age +
                '}';
    }
}
