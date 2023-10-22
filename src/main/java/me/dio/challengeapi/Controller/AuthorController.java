package me.dio.challengeapi.Controller;

import me.dio.challengeapi.Entity.Author;
import me.dio.challengeapi.Service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/add")
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author) {
        Author savedAuthor = authorService.saveAuthorBook(author);
        return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
    }

    @GetMapping("/{id_author}")
    public ResponseEntity<Author> findById(@PathVariable Integer id_author) {
        Author author = authorService.findById(id_author);
        return ResponseEntity.ok(author);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Author>> findAll() {
        List<Author> authorList = authorService.findAll();
        return ResponseEntity.ok(authorList);
    }

    @DeleteMapping("/delete/{id_author}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id_author) {
        authorService.findAndDeleteAuthor(id_author);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {
        Author updatedAuthor = authorService.updateAuthor(author);
        return ResponseEntity.ok(updatedAuthor);
    }
}
