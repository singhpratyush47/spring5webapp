package guru.springFramework.spring5webapp.bootstrap;

import guru.springFramework.spring5webapp.model.Author;
import guru.springFramework.spring5webapp.model.Book;
import guru.springFramework.spring5webapp.model.Publisher;
import guru.springFramework.spring5webapp.repositories.AuthorRepository;
import guru.springFramework.spring5webapp.repositories.BookRepository;
import guru.springFramework.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * Created by PRATYUSH on 18-11-2018.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    /**
     * instead of auto wired can call this constructor also
     * @param contextRefreshedEvent
     */
    /*public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
*/
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
    initData();
    }

    private void initData()
    {

        /**
         * this right here is thetraditional approach to create a set then load that set then add that
         * set to an attribute and save instead we can getTheSet using getter and apply add
         * method on it as shown in section two code snippet.
         */
        Author eric=new Author("Eric","Evans");
        Publisher publisher=new Publisher("Harper Collins","USA");
        Book domainDrivenDesign=new Book("Domain Driven Design","1234",publisher);
        HashSet setOfBooks=new HashSet();
        HashSet setOfAuthors=new HashSet();
        setOfBooks.add(domainDrivenDesign);
        setOfAuthors.add(domainDrivenDesign);
        eric.setBooks(setOfBooks);
        domainDrivenDesign.setAuthors(setOfAuthors);

        publisherRepository.save(publisher);
        bookRepository.save(domainDrivenDesign);
        authorRepository.save(eric);

        /**
         * Section two
         */
        Author rodJohnson=new Author("Rod","JohnSon");
        Publisher publisher1=new Publisher("pivotal","Europe");
        Book noEJb=new Book("using J2ee without Ejb","5678",publisher1);
        rodJohnson.getBooks().add(noEJb);
        noEJb.getAuthors().add(rodJohnson);
        publisherRepository.save(publisher1);
        bookRepository.save(noEJb);
        authorRepository.save(rodJohnson);

    }

}
