package me.dio.challengeapi.Repository;

import me.dio.challengeapi.Entity.Author;
import me.dio.challengeapi.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {


    @Override
    List<Book> findAll();

    @Query(value = "SELECT bb from Book bb where bb.id_book =?1")
    Book findBook(Integer id_book);
}
