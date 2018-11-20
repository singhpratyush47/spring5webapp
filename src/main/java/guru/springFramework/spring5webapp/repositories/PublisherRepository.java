package guru.springFramework.spring5webapp.repositories;

import guru.springFramework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by PRATYUSH on 18-11-2018.
 */
@Repository
public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
