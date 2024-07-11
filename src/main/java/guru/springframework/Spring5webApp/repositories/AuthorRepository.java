package guru.springframework.Spring5webApp.repositories;

import guru.springframework.Spring5webApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
