package pl.danelekoo7.book_library.manager;


import org.springframework.stereotype.Service;
import pl.danelekoo7.book_library.dao.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemoryBookService implements BookService {
    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
       }

    @Override
    public Iterable<Book> findAll() {
        return list;
    }

    @Override
    public Optional<Book> findById(Long id) {
        for (Book b : list) {
            if (b.getId() == id) {
                return Optional.of(b);
            }
        }
        return Optional.empty();
    }

    @Override
    public void save(Book book) {
        for (Book b : list) {
            if (b.getId() == book.getId()) {
                b.setAuthor(book.getAuthor());
                b.setPublisher(book.getPublisher());
                b.setIsbn(book.getIsbn());
                b.setTitle(book.getTitle());
                b.setType(book.getType());
            }
        }
    }

    public void add(Book book) {
        list.add(book);
    }

    @Override
    public void delete(Long id) {
        list.remove(findById(id));
    }
}
