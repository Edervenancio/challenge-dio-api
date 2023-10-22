package me.dio.challengeapi.Book;

import me.dio.challengeapi.Entity.Book;
import me.dio.challengeapi.Repository.BookRepository;
import me.dio.challengeapi.Service.BookService;
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
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Test: Find all books")
    @Test
    @Order(1)
    void findAllBooks() {
        List<Book> bookList = new ArrayList<>();

        Book bookOne = new Book(1, "book one", "book category one",
                "book description one", 1);
        Book bookTwo = new Book(2, "book two", "book category two",
                "book description two", 2);

        bookList.add(bookOne);
        bookList.add(bookTwo);

        when(bookRepository.findAll()).thenReturn(bookList);

        this.bookService.findAll();

        Assert.assertNotNull("Book list should not be null", bookList);
        Assert.assertFalse("Book list should not be empty", bookList.isEmpty());
        Assert.assertEquals("Book list should have 2 elements", 2, bookList.size());
    }

    @DisplayName("Test: Find book by ID")
    @Test
    @Order(2)
    void findById() {
        Integer id_book = 1;
        Book foundBook = new Book(id_book, "book one", "book category one",
                "book description one", 1);

        when(bookRepository.findBook(foundBook.getId_book())).thenReturn(foundBook);

        this.bookService.findById(id_book);

        Assert.assertNotNull("Found book should not be null", foundBook);
        Assert.assertEquals("Book ID should match the provided ID", id_book, foundBook.getId_book());
    }

    @DisplayName("Test: Save book")
    @Test
    @Order(3)
    void saveBookTest() {
        Book bookOne = new Book(1, "book one", "book category one",
                "book description one", 1);

        Mockito.when(bookRepository.save(bookOne)).thenReturn(bookOne);

        this.bookService.saveBook(bookOne);

        Assert.assertNotNull("Book object should not be null after saving", bookOne);
    }

    @DisplayName("Test: Update book")
    @Test
    @Order(4)
    void updateBookTest() {
        Book bookOne = new Book(1, "book one", "book category one",
                "book description one", 1);

        Mockito.when(bookRepository.save(bookOne)).thenReturn(bookOne);

        bookOne.setBook_name("book two");
        bookOne.setBook_category("book category two");
        bookOne.setBook_description("book description two");
        bookOne.setPages(2);

        this.bookService.saveBook(bookOne);

        Assert.assertEquals("Book name should be updated", "book two", bookOne.getBook_name());
        Assert.assertEquals("Book category should be updated", "book category two", bookOne.getBook_category());
        Assert.assertEquals("Book description should be updated", "book description two", bookOne.getBook_description());
        Assert.assertEquals("Number of pages should be updated", Integer.valueOf(2), bookOne.getPages());
    }
}
