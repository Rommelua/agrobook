package bookshelter.dao;

import bookshelter.model.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ShelterDAO {

    @PersistenceContext
    private EntityManager em;


    @SuppressWarnings("unchecked")
    public List<Book> getListOfBooks() {
        return em.createQuery("from Book").getResultList();
    }

    public Book saveBook(Book book) {
        em.persist(book);
        return book;
    }

}
