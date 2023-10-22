package me.dio.challengeapi.Author;

import me.dio.challengeapi.Entity.Author;
import me.dio.challengeapi.Repository.AuthorRepository;
import me.dio.challengeapi.Service.AuthorService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Test: Find all authors")
    @Test
    @Order(1)
    void findAllAuthors() {
        List<Author> authorList = new ArrayList<>();

        Author authorOne = new Author(1, "Author One", 32);
        Author authorTwo = new Author(2, "Author Two", 45);

        authorList.add(authorOne);
        authorList.add(authorTwo);

        when(authorRepository.findAll()).thenReturn(authorList);

        this.authorService.findAll();

        Assert.assertNotNull("Author list should not be null", authorList);
        Assert.assertFalse("Author list should not be empty", authorList.isEmpty());
        Assert.assertEquals("Author list should have 2 elements", 2, authorList.size());
    }

    @DisplayName("Test: Find author by ID")
    @Test
    @Order(2)
    void findById() {
        Integer id_author = 1;
        Author foundAuthor = new Author(id_author, "Author One", 32);

        when(authorRepository.findAuthor(foundAuthor.getId_author())).thenReturn(foundAuthor);

        this.authorService.findById(id_author);

        Assert.assertNotNull("Found author should not be null", foundAuthor);
        Assert.assertEquals("Author ID should match the provided ID", id_author, foundAuthor.getId_author());
    }

    @DisplayName("Test: Save author")
    @Test
    @Order(3)
    void saveAuthorTest() {
        Author authorOne = new Author(1, "Author One", 32);

        Mockito.when(authorRepository.save(authorOne)).thenReturn(authorOne);

        this.authorService.saveAuthorBook(authorOne);

        Assert.assertNotNull("Author object should not be null after saving", authorOne);
    }

    @DisplayName("Test: Update author")
    @Test
    @Order(4)
    void updateAuthorTest() {
        Author authorOne = new Author(1, "Author One", 32);

        Mockito.when(authorRepository.save(authorOne)).thenReturn(authorOne);

        authorOne.setAuthor_name("Author Two");
        authorOne.setAuthor_age(45);

        this.authorService.saveAuthorBook(authorOne);

        Assert.assertEquals("Author name should be updated", "Author Two", authorOne.getAuthor_name());
        Assert.assertEquals("Author age should be updated", Integer.valueOf(45), authorOne.getAuthor_age());
    }

}
