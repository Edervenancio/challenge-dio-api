package me.dio.challengeapi.Controller;

import me.dio.challengeapi.Entity.Book;
import me.dio.challengeapi.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Book>> findAll() {
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id_book}")
    public ResponseEntity<Book> findById(@PathVariable Integer id_book) {
        Book book = bookService.findById(id_book);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/delete/{id_book}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id_book) {
        bookService.findAndDeleteBook(id_book);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book updatedBook = bookService.updateBook(book);
        return ResponseEntity.ok(updatedBook);
    }

    @PutMapping("/{id_book}/author/{id_author}")
    public ResponseEntity<Book> assignAuthorToBook(@PathVariable Integer id_book, @PathVariable Integer id_author) {
        Book book = bookService.assignAuthorToBook(id_book, id_author);
        return ResponseEntity.ok(book);
    }


}
