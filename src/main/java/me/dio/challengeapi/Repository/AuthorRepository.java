package me.dio.challengeapi.Repository;

import me.dio.challengeapi.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Transactional
    Author save(Author author);


    @Query(value = "SELECT aa from Author aa where aa.id_author =?1")
    Author findAuthor(Integer id_author);

    @Override
    List<Author> findAll();
}
