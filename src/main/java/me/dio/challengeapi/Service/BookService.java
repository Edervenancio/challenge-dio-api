package me.dio.challengeapi.Service;

import me.dio.challengeapi.Entity.Author;
import me.dio.challengeapi.Entity.Book;
import me.dio.challengeapi.Repository.AuthorRepository;
import me.dio.challengeapi.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Set;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Book updateBook(Book book) {
        book.setId_book(book.getId_book());
        Book updatedBook = bookRepository.save(book);
        return updatedBook;
    }

    public void findAndDeleteBook(Integer id_book) {
        bookRepository.deleteById(id_book);
    }

    @Transactional
    public Book saveBook(Book book) {
        book.setId_book(0);
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(int id_book) {
        Book foundBook = bookRepository.findBook(id_book);
        return foundBook;
    }

    public Book assignAuthorToBook(Integer id_book, Integer id_author) {
        Book book = findById(id_book);
        Author author = authorRepository.findAuthor(id_author);
        Set<Author> authorSet = book.getAuthors();
        authorSet.add(author);
        book.setAuthors(authorSet);
        return bookRepository.save(book);
    }
}
