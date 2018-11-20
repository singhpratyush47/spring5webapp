package guru.springFramework.spring5webapp.repositories;

import guru.springFramework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by PRATYUSH on 18-11-2018.
 */
@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
}
