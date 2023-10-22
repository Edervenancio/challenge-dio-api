package me.dio.challengeapi.Service;

import me.dio.challengeapi.Entity.Author;
import me.dio.challengeapi.Repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author findById(Integer id_author) {
        return authorRepository.findAuthor(id_author);
    }

    @Transactional
    public Author saveAuthorBook(Author author) {
        author.setId_author(0);
        return authorRepository.save(author);
    }

    @Transactional
    public Author updateAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void findAndDeleteAuthor(Integer id_author) {
        authorRepository.deleteById(id_author);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
