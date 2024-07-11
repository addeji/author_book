package guru.springframework.Spring5webApp.bootstrap;

import guru.springframework.Spring5webApp.domain.Author;
import guru.springframework.Spring5webApp.domain.Book;
import guru.springframework.Spring5webApp.domain.Publishers;
import guru.springframework.Spring5webApp.repositories.AuthorRepository;
import guru.springframework.Spring5webApp.repositories.BookRepository;

import guru.springframework.Spring5webApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository
            , PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;

    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in BootStrap");
        Publishers publishers = new Publishers();
        publishers.setPublisherName("Epic");
        publishers.setAddressline1("ikorodu,erunwen");
        publishers.setCity("Lagos");
        publishers.setZip("174333");
        publisherRepository.save(publishers);
        System.out.println(" name:" + publishers.getPublisherName());









        Author eric = new Author("eric","aurthur");
        Book Got = new Book("Book of Ice","2456876453");


        eric.getBooks().add(Got);
        Got.getAuthors().add(eric);
        Got.setPublishers(publishers);
        publishers.getBooks().add(Got);



        authorRepository.save(eric);
        bookRepository.save(Got);
        publisherRepository.save(publishers);

        Publishers publisher = new Publishers();
        publisher.setPublisherName("Ea");
        publisher.setAddressline1("ikeja,mainland ,lagos");
        publisher.setCity("Lagos");
        publisher.setZip("100001");
        publisherRepository.save(publisher);
        System.out.println(" name:" + publisher.getPublisherName());



        Author rod = new Author("Rod","james");
        Book ToG = new Book("Throne of Glass","1443876453");

        rod.getBooks().add(ToG);
        ToG.getAuthors().add(rod);
        ToG.setPublishers(publisher);
        publisher.getBooks().add(ToG);




        authorRepository.save(rod);
        bookRepository.save(ToG);
        publisherRepository.save(publisher);
        System.out.println(" books published:" + publishers.getBooks().size());
        System.out.println(" books published:" + publisher.getBooks().size());



        System.out.println("Total");
        System.out.println("Number of Books :" + bookRepository.count());
        System.out.println("Number of Authors :" + authorRepository.count());
        System.out.println(" Number of Publishers:" + publisherRepository.count());





    }

}
