package pl.danelekoo7.book_library.api;


import org.springframework.web.bind.annotation.*;
import pl.danelekoo7.book_library.dao.entity.Book;
import pl.danelekoo7.book_library.manager.BookService;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookApi {

    private final BookService bookService;

    public BookApi(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Iterable<Book> getBooks() {
        return bookService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Book> getBooks(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public void add(@RequestBody Book book) {

        bookService.save(book);
    }

    @PutMapping("{id}")
    public void put( @ PathVariable Long id, @RequestBody Book book) {

        bookService.update(id, book);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
}
