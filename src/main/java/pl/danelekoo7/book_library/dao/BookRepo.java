package pl.danelekoo7.book_library.dao;

import org.springframework.data.repository.CrudRepository;
import pl.danelekoo7.book_library.dao.entity.Book;

public interface BookRepo  extends CrudRepository<Book,Long>{
}
