package guru.springframework.Spring5webApp.repositories;

import guru.springframework.Spring5webApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
