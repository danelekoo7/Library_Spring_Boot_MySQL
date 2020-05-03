package pl.danelekoo7.book_library.manager;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.danelekoo7.book_library.dao.BookRepo;
import pl.danelekoo7.book_library.dao.entity.Book;

import java.util.Optional;

@Service
@Primary
public class DbBookService implements BookService {

    private final BookRepo bookRepo;

    public DbBookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepo.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book update(Long id, Book book) {
        return bookRepo.findById(id)
                .map(newBook -> {
                    newBook.setTitle(book.getTitle());
                    newBook.setAuthor(book.getAuthor());
                    newBook.setPublisher(book.getPublisher());
                    newBook.setIsbn(book.getIsbn());
                    newBook.setType(book.getType());
                    return bookRepo.save(newBook);
                })
                .orElseGet(() -> {
                    book.setId(id);
                    return bookRepo.save(book);
                });
    }

    @Override
    public void delete(Long id) {
        bookRepo.deleteById(id);
    }
}
