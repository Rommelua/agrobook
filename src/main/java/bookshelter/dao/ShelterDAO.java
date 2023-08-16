package bookshelter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import bookshelter.model.Book;

@Repository
public class ShelterDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	public List<Book> getListOfBooks(){
		return em.createQuery("from Book").getResultList();
	}
	
}
