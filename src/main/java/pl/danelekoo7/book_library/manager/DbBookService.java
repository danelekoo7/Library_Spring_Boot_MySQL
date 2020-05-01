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
    public void save(Book book) {
        bookRepo.save(book);
    }

    @Override
    public void delete(Long id) {
      bookRepo.deleteById(id);
    }
}
