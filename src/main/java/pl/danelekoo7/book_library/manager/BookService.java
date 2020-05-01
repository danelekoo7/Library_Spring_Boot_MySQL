package pl.danelekoo7.book_library.manager;


import pl.danelekoo7.book_library.dao.entity.Book;

import java.util.Optional;

public interface BookService {

    Iterable<Book> findAll();

    Optional<Book> findById(Long id);

    void save(Book book);

    void delete(Long id);
}
